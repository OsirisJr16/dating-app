package com.example.dating.service;

import com.example.dating.DTO.MatchDTO;
import com.example.dating.DTO.MatchedByDTO;
import com.example.dating.DTO.UserDTO;
import com.example.dating.entity.Match;
import com.example.dating.entity.User;
import com.example.dating.repository.MatchRepository;
import com.example.dating.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchService {
    private final MatchRepository matchRepository;
    private final  UserRepository userRepository;

    public MatchService(MatchRepository matchRepository, UserRepository userRepository) {
        this.matchRepository = matchRepository;
        this.userRepository = userRepository;
    }

    public List<MatchDTO> getMatchesByUser(Long userId) {
        User user = userRepository.findByUserID(userId) ;
        if(user == null) return null;
        return  matchRepository.findByUser1(user).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    public List<MatchedByDTO> getMatchesMatchedByUser(Long userId) {
        User user = userRepository.findByUserID(userId);
        if(user == null) return null;
        return  matchRepository.findByUser2(user).stream()
                .map(this::convertMatchedByToDTO)
                .collect(Collectors.toList());
    }

    private MatchDTO convertToDTO(Match match){
        MatchDTO dto = new MatchDTO() ;
        dto.setMatchID(match.getMatchID());
        dto.setUser(convertoUserDTO(match.getUser2()));
        return dto ;
    }
    private MatchedByDTO convertMatchedByToDTO(Match match){
        MatchedByDTO dto = new MatchedByDTO();
        dto.setMatchId(match.getMatchID());
        dto.setUser(convertoUserDTO(match.getUser1()));
        return  dto ;
    }
    private UserDTO convertoUserDTO(User user){
        UserDTO dto = new UserDTO() ;
        dto.setUserId(user.getUserID());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setBirthday(user.getBirthday());
        dto.setProfilePicture(user.getProfilePicture());
        return  dto ;
    }

}
