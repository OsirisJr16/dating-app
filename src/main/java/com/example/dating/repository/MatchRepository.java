package com.example.dating.repository;

import com.example.dating.entity.Match;
import com.example.dating.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match , Long> {
    List<Match> findByUser1(User user);
    List<Match> findByUser2(User user);
}
