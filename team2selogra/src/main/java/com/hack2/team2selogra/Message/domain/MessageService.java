package com.hack2.team2selogra.Message.domain;

import com.hack2.team2selogra.Chat.domain.Chat;
import com.hack2.team2selogra.Chat.infraestructure.ChatRepository;
import com.hack2.team2selogra.Message.infraestructure.MessageRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class MessageService {
    private final MessageRepository messageRepository;
    private final ChatRepository chatRepository;

    public MessageService(MessageRepository messageRepository, ChatRepository chatRepository) {
        this.messageRepository = messageRepository;
        this.chatRepository = chatRepository;
    }

    public void sendMessage(UUID chatId, Sender sender, String content, LocalDateTime timestamp, AIModel aiModel) {
        Chat chat = chatRepository.findById(chatId)
                .orElseThrow(() -> new IllegalArgumentException("Chat no encontrado."));

        Message message = new Message();
        message.setChat(chat);
        message.setSender(sender);
        message.setContent(content);
        message.setTimestamp(timestamp);
        message.setAiModel(aiModel);

        messageRepository.save(message);
    }
}
