package com.example.dating.DTO;

public class MatchDTO {
    private long matchID ;
    private UserDTO user ;

    public MatchDTO(long matchID, UserDTO user) {
        this.matchID = matchID;
        this.user = user;
    }
    public MatchDTO(){

    }

    public long getMatchID() {
        return matchID;
    }

    public void setMatchID(long matchID) {
        this.matchID = matchID;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
