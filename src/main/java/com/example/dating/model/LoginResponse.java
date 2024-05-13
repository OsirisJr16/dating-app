package com.example.dating.model;

public class LoginResponse {
    private  Long id ;
    private String email ;
    private String username ;
    private String message ;

    public LoginResponse(Long id, String email, String username, String message) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
