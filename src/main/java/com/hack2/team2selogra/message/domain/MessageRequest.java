package com.hack2.team2selogra.message.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class MessageRequest {
    private UUID chatId;
    private Sender sender;
    private String content;
    private LocalDateTime timestamp;
    private AIModel aiModel;
}
