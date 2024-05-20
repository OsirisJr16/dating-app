package com.example.dating.service;

import com.example.dating.DTO.LocationDTO;
import com.example.dating.DTO.ProfileDTO;
import com.example.dating.entity.User;
import com.example.dating.entity.Interest ;

import java.util.List;
import java.util.stream.Collectors;

public class ProfileDTOService {
    public  static ProfileDTO converToProfileDTO(User user){
        ProfileDTO profileDTO = new ProfileDTO();
        profileDTO.setId(user.getUserID());
        profileDTO.setUsername(user.getUsername());
        profileDTO.setEmail(user.getEmail());
        profileDTO.setBio(user.getBio());
        profileDTO.setBirthday(user.getBirthday());
        profileDTO.setProfilePicture(user.getProfilePicture());
        profileDTO.setGender(user.getGender());
        if (user.getLocation() != null) {
            LocationDTO locationDTO = new LocationDTO();
            locationDTO.setLatitude(user.getLocation().getLatitude());
            locationDTO.setLongitude(user.getLocation().getLongitude());
            profileDTO.setLocation(locationDTO);
        }
        List<String> interests = user.getInterests().stream()
                .map(Interest::getInterest)
                .collect(Collectors.toList());
        profileDTO.setInterests(interests);
        return profileDTO;
    }
}
