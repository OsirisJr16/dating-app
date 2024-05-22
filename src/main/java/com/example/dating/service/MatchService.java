package com.example.dating.service;

import com.example.dating.entity.Match;
import com.example.dating.entity.User;
import com.example.dating.repository.MatchRepository;
import com.example.dating.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {
    private final MatchRepository matchRepository;
    private final  UserRepository userRepository;

    public MatchService(MatchRepository matchRepository, UserRepository userRepository) {
        this.matchRepository = matchRepository;
        this.userRepository = userRepository;
    }

    public List<Match> getMatchesByUser(Long userId) {
        User user = userRepository.findByUserID(userId) ;
        if(user == null) return null;
        return  matchRepository.findByUser1(user) ;
    }
    public List<Match> getMatchesMatchedByUser(Long userId) {
        User user = userRepository.findByUserID(userId);
        if(user == null) return null;
        return  matchRepository.findByUser2(user) ;
    }

}
