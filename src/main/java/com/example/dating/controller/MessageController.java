package com.example.dating.controller;

import com.example.dating.entity.Message;
import com.example.dating.service.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/message")
public class MessageController {
    private final MessageService messageService;
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public List<Message> getMessages(@RequestParam Long senderId, @RequestParam Long receiverId) {
        return messageService.getMessagesBetweenUsers(senderId , receiverId) ;
    }
    @PostMapping
    public void addMessage(@RequestBody Message message) {
        messageService.saveMessage(message);
    }
}
