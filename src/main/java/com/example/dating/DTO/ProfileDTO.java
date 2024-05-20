package com.example.dating.DTO;

import java.time.LocalDate;
import java.util.List;

public class ProfileDTO {
    private Long id ;
    private String username ;
    private String email  ;
    private String gender;
    private LocalDate birthday ;
    private String bio ;
    private String profilePicture;
    private List<String> interests ;
    private LocationDTO location ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProfileDTO(String username, String email, String gender, LocalDate birthday, String bio,String profilePicture,List<String> interests, LocationDTO location) {
        this.username = username;
        this.email = email;
        this.gender = gender;
        this.birthday = birthday;
        this.bio = bio;
        this.profilePicture = profilePicture;
        this.interests = interests;
        this.location = location;
    }
    public  ProfileDTO(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getProfilePicture() {return profilePicture;}

    public void setProfilePicture(String profilePicture) {this.profilePicture = profilePicture;}

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public LocationDTO getLocation() {
        return location;
    }

    public void setLocation(LocationDTO location) {
        this.location = location;
    }
}
