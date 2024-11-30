package com.hack2.team2selogra.Chat.application;

import com.hack2.team2selogra.Chat.domain.Chat;
import com.hack2.team2selogra.Chat.domain.ChatService;
import com.hack2.team2selogra.Chat.domain.CreateChatRequest;
import com.hack2.team2selogra.Message.domain.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/chats")
    public ResponseEntity<List<Chat>> getChats(@RequestParam UUID userId) {
        List<Chat> chats = chatService.getChatsByUserId(userId);
        return ResponseEntity.ok(chats);
    }

    @PostMapping("/chats")
    public ResponseEntity<String> createChat(@RequestBody CreateChatRequest chatRequest) {
        chatService.createChat(chatRequest.getUserId(), chatRequest.getChatName());
        return ResponseEntity.ok("Chat creado exitosamente.");
    }

    @GetMapping("/chats/{id}")
    public ResponseEntity<List<Message>> getMessagesByChatId(@PathVariable UUID id) {
        List<Message> messages = chatService.getMessagesByChatId(id);
        return ResponseEntity.ok(messages);
    }
}
