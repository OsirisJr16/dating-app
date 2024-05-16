package com.example.dating.controller;

import com.example.dating.entity.*;
import com.example.dating.model.LoginResponse;
import com.example.dating.model.RegistrationRequest;
import com.example.dating.repository.InterestRepository;
import com.example.dating.repository.LocationRepository;
import com.example.dating.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserRepository userRepository ;
    private final InterestRepository interestRepository ;
    private final LocationRepository locationRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public AuthController(UserRepository userRepository, InterestRepository interestRepository, LocationRepository locationRepository) {
        this.userRepository = userRepository;
        this.interestRepository = interestRepository;
        this.locationRepository = locationRepository;
    }
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegistrationRequest request) throws IOException {
        User user = request.getUser();
        List<String> interests = request.getInterests();
        Location location = request.getLocation();

        if (userRepository.existsByEmail(user.getEmail())) {
            return new ResponseEntity<>("Email already exists", HttpStatus.BAD_REQUEST);
        }

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        if(request.getProfilePictureUrl() != null){
            String profilePictureUrl = request.getProfilePictureUrl();
            String[] urlParts = profilePictureUrl.split("/");
            String fileName = urlParts[urlParts.length - 1];
            String uploadDir = "upload/profiles/";
            Path path = Paths.get(uploadDir + fileName);

            try (InputStream in = new URL(profilePictureUrl).openStream()) {
                Files.copy(in, path);
            } catch (IOException e) {
                e.printStackTrace();
                return new ResponseEntity<>("Failed to download profile picture", HttpStatus.INTERNAL_SERVER_ERROR);
            }

            user.setProfilePicture(uploadDir + fileName);
        }

        userRepository.save(user);

        for (String interest : interests) {
            Interest newInterest = new Interest();
            newInterest.setUser(user);
            newInterest.setInterest(interest);
            interestRepository.save(newInterest);
        }

        location.setUser(user);
        location.setTimestamp(LocalDateTime.now());
        locationRepository.save(location);

        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody User loginUser) {
        User user = userRepository.findByEmail(loginUser.getEmail());
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        if (!bCryptPasswordEncoder.matches(loginUser.getPassword(), user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginResponse(null, null, null, "Incorrect password"));
        }
        LoginResponse loginResponse = new LoginResponse(user.getUserID(), user.getEmail(), user.getUsername(), "Login Success");
        return ResponseEntity.ok(loginResponse);
    }


}
