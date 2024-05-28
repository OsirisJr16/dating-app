package com.example.dating.repository;

import com.example.dating.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message , Long> {
    @Query("SELECT m FROM Message m WHERE (m.sender.userID = :senderId AND m.receiver.userID = :receiverId) OR (m.sender.userID = :receiverId AND m.receiver.userID = :senderId) ORDER BY m.timestamp ASC")
    List<Message> findMessageBetweenUsers(Long senderId, Long receiverId);
}

