package com.example.dating.DTO;

public class MatchedByDTO {
    private long matchId;
    private UserDTO user ;

    public MatchedByDTO(long matchId, UserDTO user) {
        this.matchId = matchId;
        this.user = user;
    }
    public MatchedByDTO(){

    }
    public long getMatchId() {
        return matchId;
    }

    public void setMatchId(long matchId) {
        this.matchId = matchId;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

}
