package com.example.dating.repository;

import com.example.dating.entity.Interest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestRepository  extends JpaRepository<Interest , Long> {
}
