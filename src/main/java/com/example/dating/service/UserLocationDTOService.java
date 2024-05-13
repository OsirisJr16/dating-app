package com.example.dating.service;

import com.example.dating.DTO.UserLocationDTO;
import com.example.dating.entity.User;

public class UserLocationDTOService {
    public static UserLocationDTO convertToUserLocationDTO(User user){
        UserLocationDTO userLocationDTO = new UserLocationDTO()   ;
        userLocationDTO.setId(user.getUserID());
        userLocationDTO.setUsername(user.getUsername());
        userLocationDTO.setLatitude(user.getLocation().getLatitude());
        userLocationDTO.setLongitude(user.getLocation().getLongitude());
        return  userLocationDTO ;

    }
}
