package com.hack2.team2selogra.message.domain;

import com.hack2.team2selogra.chat.domain.Chat;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    // Se mantiene la relación con Chat
    @ManyToOne
    @JoinColumn(name = "chat_id", nullable = false)
    private Chat chat;

    // Si necesitas chatID como campo explícito, lo añades (opcional)
    @Transient // No se almacena en la base de datos
    private UUID chatID;

    @Enumerated(EnumType.STRING)
    private Sender sender;

    private String content;

    private LocalDateTime timestamp;

    @Enumerated(EnumType.STRING)
    private AIModel aiModel;

    // Método para obtener chatID explícitamente desde el objeto Chat
    public UUID getChatID() {
        return chat != null ? chat.getId() : null;
    }
}
