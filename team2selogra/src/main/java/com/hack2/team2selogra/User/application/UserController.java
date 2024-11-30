package com.hack2.team2selogra.User.application;

import com.hack2.team2selogra.User.domain.LoginRequest;
import com.hack2.team2selogra.User.domain.User;
import com.hack2.team2selogra.User.domain.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        userService.register(user);
        return ResponseEntity.ok("Usuario registrado exitosamente.");
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequest loginRequest) {
        boolean isAuthenticated = userService.login(loginRequest.getEmail(), loginRequest.getPassword());
        if (isAuthenticated) {
            return ResponseEntity.ok("Inicio de sesión exitoso.");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas.");
    }
}
