package com.hack2.team2selogra.Message.infraestructure;

import com.hack2.team2selogra.Message.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MessageRepository extends JpaRepository<Message, UUID> {
    List<Message> findByChatId(UUID chatId);
}
