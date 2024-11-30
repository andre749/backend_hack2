package com.hack2.team2selogra.User.domain;

import com.hack2.team2selogra.User.infraestructure.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("El correo ya está registrado.");
        }
        userRepository.save(user);
    }

    public boolean login(String email, String password) {
        return userRepository.findByEmail(email)
                .map(user -> user.getPassword().equals(password))
                .orElse(false);
    }
}
