package com.hack2.team2selogra.Chat.infraestructure;

import com.hack2.team2selogra.Chat.domain.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ChatRepository extends JpaRepository<Chat, UUID> {
    List<Chat> findByUserId(UUID userId);
}
