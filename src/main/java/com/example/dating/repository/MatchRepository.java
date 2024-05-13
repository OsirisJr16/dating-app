package com.example.dating.repository;

import com.example.dating.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Match , Long> {
}
