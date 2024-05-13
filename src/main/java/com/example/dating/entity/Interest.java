package com.example.dating.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "interest")
public class Interest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long interestID;
    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;
    @Column(name = "interest",nullable = false)
    private String interest;

    public Interest() {
    }

    public Interest(Long interestID, User user, String interest) {
        this.interestID = interestID;
        this.user = user;
        this.interest = interest;
    }

    public Long getInterestID() {
        return interestID;
    }

    public void setInterestID(Long interestID) {
        this.interestID = interestID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }
}