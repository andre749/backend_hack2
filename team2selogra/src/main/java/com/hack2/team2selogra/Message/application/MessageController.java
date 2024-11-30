package com.hack2.team2selogra.Message.application;

import com.hack2.team2selogra.Message.domain.MessageRequest;
import com.hack2.team2selogra.Message.domain.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/messages")
    public ResponseEntity<String> sendMessage(@RequestBody MessageRequest messageRequest) {
        messageService.sendMessage(
                messageRequest.getChatId(),
                messageRequest.getSender(),
                messageRequest.getContent(),
                messageRequest.getTimestamp(),
                messageRequest.getAiModel()
        );
        return ResponseEntity.ok("Mensaje enviado exitosamente.");
    }
}
