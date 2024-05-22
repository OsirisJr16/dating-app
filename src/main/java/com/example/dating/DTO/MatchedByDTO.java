package com.example.dating.DTO;

public class MatchedByDTO {
    private long matchId;
    private UserDTO user1 ;
    private UserDTO user2 ;

    public MatchedByDTO(long matchId, UserDTO user1, UserDTO user2) {
        this.matchId = matchId;
        this.user1 = user1;
        this.user2 = user2;
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

    public UserDTO getUser2() {
        return user2;
    }

    public void setUser2(UserDTO user2) {
        this.user2 = user2;
    }
}
