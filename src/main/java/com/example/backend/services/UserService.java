package com.example.backend.services;

import com.example.backend.model.User;
import com.example.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // public User getUserById(Long userId) {
    //     // Usa orElseThrow para manejar errores si no existe el usuario
    //     return userRepository.findById(userId)
    //             .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
    // }

    // public User getUserByEmail(String email) {
    //     // Similar lógica para buscar por email
    //     return userRepository.findByEmail(email)
    //             .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
    // }

    // public User saveUser(User user) {
    //     // Guardar un usuario en la base de datos
    //     return userRepository.save(user);
    // }

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
