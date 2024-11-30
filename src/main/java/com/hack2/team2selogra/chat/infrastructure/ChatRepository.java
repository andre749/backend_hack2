package com.hack2.team2selogra.chat.infrastructure;

import com.hack2.team2selogra.chat.domain.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ChatRepository extends JpaRepository<Chat, UUID> {
    List<Chat> findByUserId(UUID userId);
}
