package com.hack2.team2selogra.Chat.domain;

import com.hack2.team2selogra.Chat.infraestructure.ChatRepository;
import com.hack2.team2selogra.Message.domain.Message;
import com.hack2.team2selogra.User.domain.User;
import com.hack2.team2selogra.User.infraestructure.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class ChatService {
    private final ChatRepository chatRepository;
    private final UserRepository userRepository;

    public ChatService(ChatRepository chatRepository, UserRepository userRepository) {
        this.chatRepository = chatRepository;
        this.userRepository = userRepository;
    }

    public List<Chat> getChatsByUserId(UUID userId) {
        return chatRepository.findByUserId(userId);
    }

    public Chat createChat(UUID userId, String chatName) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado."));

        Chat chat = new Chat();
        chat.setUser(user);
        chat.setChatName(chatName);
        chat.setDateCreation(LocalDate.now());

        return chatRepository.save(chat); // Retorna el objeto Chat guardado
    }

    public List<Message> getMessagesByChatId(UUID chatId) {
        Chat chat = chatRepository.findById(chatId)
                .orElseThrow(() -> new IllegalArgumentException("Chat no encontrado."));
        return chat.getMessages();
    }
}
