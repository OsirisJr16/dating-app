package com.example.dating.model;

import com.example.dating.entity.Location;
import com.example.dating.entity.User;

import java.util.List;

public class RegistrationRequest {
    private User user ;
    private List<String> interests ;
    private Location location ;

    public RegistrationRequest(User user, List<String> interests, Location location) {
        this.user = user;
        this.interests = interests;
        this.location = location;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
