package com.example.demo.user.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.user.entity.User;
import com.example.demo.user.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // GET ALL USERS
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // GET USER BY ID
    public User getUserById(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "User not found with id: " + id
                ));
    }

    // CREATE USER
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // UPDATE USER
    public User updateUser(Long id, User user) {

        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "User not found with id: " + id
                ));

        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());

        return userRepository.save(existingUser);
    }

    // DELETE USER
    public void deleteUser(Long id) {

        if (!userRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "User not found with id: " + id
            );
        }

        userRepository.deleteById(id);
    }
}