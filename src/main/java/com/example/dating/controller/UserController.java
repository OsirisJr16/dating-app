package com.example.dating.controller;

import com.example.dating.DTO.ProfileDTO;
import com.example.dating.DTO.UserLocationDTO;
import com.example.dating.entity.User;
import com.example.dating.repository.UserRepository;
import com.example.dating.service.ProfileDTOService;
import com.example.dating.service.UserLocationDTOService ;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserRepository userRepository ;
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository ;
    }
    @GetMapping
    public ResponseEntity<List<ProfileDTO>> findAllUsers(){
        List<User> allUsers = (userRepository.findAll()) ;
        List<ProfileDTO> profileDTOS = allUsers.stream()
                .map(ProfileDTOService::converToProfileDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(profileDTOS) ;
    }
    @GetMapping("/location")
    public  ResponseEntity<List<UserLocationDTO>> getUsersLocation(){
        List<User> allUsers = (userRepository.findAll()) ;
        List<UserLocationDTO> userLocationDTOS = allUsers.stream()
                .map(UserLocationDTOService::convertToUserLocationDTO)
                .collect(Collectors.toList()) ;
        return  ResponseEntity.ok(userLocationDTOS) ;
    }
}