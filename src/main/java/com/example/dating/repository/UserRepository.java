package com.example.dating.repository;

import com.example.dating.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User ,Long> {
    boolean existsByEmail(String email) ;
    User findByEmail(String email) ;
    User findByUserID(Long userId);
}
