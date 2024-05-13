package com.example.dating.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "match")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matchID;
    @ManyToOne
    @JoinColumn(name = "user1ID")
    private User user1 ;
    @ManyToOne
    @JoinColumn(name = "user2ID")
    private User user2;
    @Column(name = "matchedTimestamp",nullable = false)
    private LocalDateTime matchedTimestamp ;

    public Match() {

    }
    public Match(Long matchID, User user1, User user2, LocalDateTime matchedTimestamp) {
        this.matchID = matchID;
        this.user1 = user1;
        this.user2 = user2;
        this.matchedTimestamp = matchedTimestamp;
    }

    public Long getMatchID() {
        return matchID;
    }

    public void setMatchID(Long matchID) {
        this.matchID = matchID;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public LocalDateTime getMatchedTimestamp() {
        return matchedTimestamp;
    }

    public void setMatchedTimestamp(LocalDateTime matchedTimestamp) {
        this.matchedTimestamp = matchedTimestamp;
    }
}
