package com.example.dating.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;
    @Column(name = "username",nullable = false)
    private  String username ;
    @Column(name = "email",nullable = false,unique = true)
    private String email ;
    @Column(name = "password",nullable = false)
    private String password ;
    @Column(name = "gender",nullable = false)
    private String gender ;
    @Column(name = "birthday",nullable = false)
    private LocalDate birthday ;
    @Column(name = "bio",nullable = false)
    private  String bio ;
    @Column(name = "profilePicture")
    private String profilePicture ;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Interest> interests;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private  Location location ;

    public User() {}

    public User(Long userID, String username, String email, String password, String gender, LocalDate birthday, String bio, String profilePicture, List<Interest> interests, Location location) {
        this.userID = userID;
        this.username = username;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
        this.bio = bio;
        this.profilePicture = profilePicture;
        this.interests = interests;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Interest> getInterests() {
        return interests;
    }

    public void setInterests(List<Interest> interests) {
        this.interests = interests;
    }



    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

}
