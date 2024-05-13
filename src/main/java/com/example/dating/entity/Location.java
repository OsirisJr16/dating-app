package com.example.dating.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationID;
    @OneToOne
    @JoinColumn(name = "userID")
    private  User user ;
    @Column(name = "latitude",nullable = false)
    private Double latitude ;
    @Column(name = "longitude",nullable = false)
    private Double longitude ;
    @Column(name = "timestamp",nullable = false)
    private LocalDateTime timestamp ;

    public Location() {

    }
    public Location(Long locationID, User user, Double latitude, Double longitude, LocalDateTime timestamp) {
        this.locationID = locationID;
        this.user = user;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timestamp = timestamp;
    }

    public Long getLocationID() {
        return locationID;
    }

    public void setLocationID(Long locationID) {
        this.locationID = locationID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
