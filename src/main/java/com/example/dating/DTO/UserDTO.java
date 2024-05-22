package com.example.dating.DTO;

import java.time.LocalDate;

public class UserDTO {
    private Long userId ;
    private String username ;
    private String email ;
    private LocalDate birthday;
    private String profilePicture ;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public UserDTO(Long userId, String username, String email, LocalDate birthday, String profilePicture) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.birthday = birthday;
        this.profilePicture = profilePicture;
    }
    public UserDTO(){

    }
}
