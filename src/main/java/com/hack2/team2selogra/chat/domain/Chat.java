package com.hack2.team2selogra.chat.domain;

import com.hack2.team2selogra.auth.domain.UserAccount;
import com.hack2.team2selogra.message.domain.Message;
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
    private UserAccount user;

    private String chatName;

    private LocalDate dateCreation;

    @OneToMany(mappedBy = "chat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> messages;
}
