package com.example.dating.DTO;

public class MatchedByDTO {
    private long matchId;
    private UserDTO user1 ;

    public MatchedByDTO(long matchId, UserDTO user1) {
        this.matchId = matchId;
        this.user1 = user1;
    }
    public MatchedByDTO(){

    }
    public long getMatchId() {
        return matchId;
    }

    public void setMatchId(long matchId) {
        this.matchId = matchId;
    }

    public UserDTO getUser1() {
        return user1;
    }

    public void setUser1(UserDTO user1) {
        this.user1 = user1;
    }

}
