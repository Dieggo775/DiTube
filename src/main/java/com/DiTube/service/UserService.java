package com.DiTube.service;

import com.DiTube.model.User;
import com.DiTube.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Criar novo usuario
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Buscar usuario por ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Buscar todos os usuarios
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Buscar por username
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Buscar por email
    public Optional<User> getUserEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Atualizar usuario
    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setUsername(updatedUser.getUsername());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            return userRepository.save(user);
        }).orElse(null);
    }

    // Deletar usuario
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
