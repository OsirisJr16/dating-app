package com.example.dating.controller;
import com.example.dating.DTO.MatchDTO;
import com.example.dating.DTO.MatchedByDTO;
import com.example.dating.DTO.ProfileDTO;
import com.example.dating.entity.*;
import com.example.dating.model.MatchRequest;
import com.example.dating.repository.MatchRepository;
import com.example.dating.repository.UserRepository;
import com.example.dating.service.MatchService;
import com.example.dating.service.ProfileDTOService ;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/match")
public class MatchController {
    private final UserRepository userRepository;
    private final MatchRepository matchRepository ;
    private final MatchService matchService ;

    public MatchController(UserRepository userRepository , MatchRepository matchRepository , MatchService matchService) {
        this.userRepository = userRepository;
        this.matchRepository = matchRepository;
        this.matchService = matchService;
    }

    @PostMapping
    public ResponseEntity<String>createMatch(@RequestBody MatchRequest matchRequest){
        User user1 = userRepository.findByUserID(matchRequest.getUser1ID()) ;
        User user2 = userRepository.findByUserID(matchRequest.getUser2ID()) ;
        if(user1 == null || user2 ==null){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Users not found") ;
        }
        Match match = new Match() ;
        match.setUser1(user1);
        match.setUser2(user2);
        match.setMatchedTimestamp(LocalDateTime.now());
        matchRepository.save(match) ;
        return  ResponseEntity.ok("Match created Successfully") ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ProfileDTO>> findMatches(@PathVariable Long id) {
        User currentUser = userRepository.findByUserID(id);
        if (currentUser == null) {
            return ResponseEntity.notFound().build();
        }
        List<User> allUsers = userRepository.findAll() ;
        List<ProfileDTO> matches = userRepository.findAll().stream()
                .filter(user -> user.getGender().equals(getOppositeGender(currentUser.getGender())))
                .map(user -> {
                    double matchingScore = calculateMatchingScore(currentUser, user);
                    if (matchingScore >= 0.5) {
                        return ProfileDTOService.converToProfileDTO(user);
                    } else {
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingDouble(profileDTO -> calculateMatchingScore(currentUser,  userFromProfileDTO((ProfileDTO) profileDTO))).reversed())
                .collect(Collectors.toList());
        if(matches.isEmpty()){
            List<ProfileDTO> oppositeGenderUsers =allUsers.stream()
                    .filter(user -> user.getGender().equals(getOppositeGender(currentUser.getGender())))
                    .map(ProfileDTOService::converToProfileDTO)
                    .collect(Collectors.toList()) ;
            return ResponseEntity.ok(oppositeGenderUsers) ;
        }
        return ResponseEntity.ok(matches);
    }

    @GetMapping("/user/{userId}/matches")
    public ResponseEntity<List<MatchDTO>> getMatchesByUserID(@PathVariable Long userId) {
        List<MatchDTO> matches = matchService.getMatchesByUser(userId);
        if (matches.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(matches) ;
    }

    @GetMapping("user/{userId}/matchedBy")
    public ResponseEntity<List<MatchedByDTO>> getMatchesByMatchedUser(@PathVariable Long userId){
        List<MatchedByDTO> matches = matchService.getMatchesMatchedByUser(userId) ;
        if(matches.isEmpty()){
            return  ResponseEntity.noContent().build();
        }
        return  ResponseEntity.ok(matches) ;
    }

    private String getOppositeGender(String gender) {
        return gender.equals("male") ? "female" : "male";
    }

    private double calculateMatchingScore(User currentUser, User otherUser) {
        double interestScore = calculateInterestScore(currentUser, otherUser);
        double locationScore = calculateLocationScore(currentUser, otherUser);
        return (interestScore + locationScore) / 2.0;
    }

    private double calculateInterestScore(User currentUser, User otherUser) {
        List<Interest> currentUserInterests = currentUser.getInterests();
        List<Interest> otherUserInterests = otherUser.getInterests();
        long commonInterestCount = currentUserInterests.stream()
                .filter(otherUserInterests::contains)
                .count();
        return (double) commonInterestCount / Math.max(currentUserInterests.size(), otherUserInterests.size());
    }

    private double calculateLocationScore(User currentUser, User otherUser) {
        if (currentUser.getLocation() == null || otherUser.getLocation() == null) {
            return 0.0;
        }
        double currentUserLongitude = currentUser.getLocation().getLongitude();
        double currentUserLatitude = currentUser.getLocation().getLatitude();

        double otherUserLongitude = otherUser.getLocation().getLongitude();
        double otherUserLatitude = otherUser.getLocation().getLatitude();
        double distance = Math.sqrt(Math.pow(currentUserLatitude - otherUserLatitude, 2)
                + Math.pow(currentUserLongitude - otherUserLongitude, 2));
        double maxDistance = Math.sqrt(2);
        return 1 - distance / maxDistance;
    }
    private User userFromProfileDTO(ProfileDTO profileDTO) {
        User user = new User();
        user.setUserID(profileDTO.getId());
        user.setUsername(profileDTO.getUsername());
        user.setEmail(profileDTO.getEmail());
        user.setBio(profileDTO.getBio());
        user.setBirthday(profileDTO.getBirthday());
        user.setGender(profileDTO.getGender());
        Location location = new Location();
        location.setLatitude(profileDTO.getLocation().getLatitude());
        location.setLongitude(profileDTO.getLocation().getLongitude());
        user.setLocation(location);
        List<Interest> interests = profileDTO.getInterests().stream()
                .map(interest -> {
                    Interest intObj = new Interest();
                    intObj.setInterest(interest);
                    intObj.setUser(user);
                    return intObj;
                })
                .collect(Collectors.toList());
        user.setInterests(interests);
        return user;
    }
}
