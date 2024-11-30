package com.hack2.team2selogra.User.domain;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
