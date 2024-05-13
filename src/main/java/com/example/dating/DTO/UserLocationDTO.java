package com.example.dating.DTO;

public class UserLocationDTO {
    private long id ;
    private String username ;

    private Double Latitude ;
    private Double Longitude ;
    public UserLocationDTO() {

    }

    public UserLocationDTO(long id, String username, Double latitude, Double longitude) {
        this.id = id;
        this.username = username;
        Latitude = latitude;
        Longitude = longitude;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getLatitude() {
        return Latitude;
    }

    public void setLatitude(Double latitude) {
        Latitude = latitude;
    }

    public Double getLongitude() {
        return Longitude;
    }

    public void setLongitude(Double longitude) {
        Longitude = longitude;
    }
}
