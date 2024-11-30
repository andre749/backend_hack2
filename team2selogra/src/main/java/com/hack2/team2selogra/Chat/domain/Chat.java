package com.hack2.team2selogra.Chat.domain;

import com.hack2.team2selogra.Message.domain.Message;
import com.hack2.team2selogra.User.domain.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // Relación con User
    private User user;

    private String chatName;

    private LocalDate dateCreation;

    @OneToMany(mappedBy = "chat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> messages;
}
