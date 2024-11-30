package com.hack2.team2selogra.chat.domain;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateChatRequest {
    private UUID userId;
    private String chatName;
}
