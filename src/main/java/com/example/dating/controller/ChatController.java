// ChatController.java
package com.example.dating.controller;

import com.example.dating.service.MessagingService;
import com.example.dating.websocket.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
public class ChatController {

    private final MessagingService messagingService;

    public ChatController(MessagingService messagingService) {
        this.messagingService = messagingService;
    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(ChatMessage chatMessage)  {
        messagingService.saveMessage(chatMessage.getSender(), chatMessage.getReceiver(), chatMessage.getContent());
        chatMessage.setTimestamp(LocalDateTime.now().toString());
        return chatMessage;
    }
}
