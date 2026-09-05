package com.example.demo.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.DuplicateEmailException;
import com.example.demo.exception.InvalidUserException;
import com.example.demo.exception.UserNotFoundException;
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

        if (id == null || id <= 0) {
            throw new InvalidUserException("Invalid user ID");
        }

        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(
                        "User not found with id: " + id
                ));
    }

    // CREATE USER
    public User createUser(User user) {

        if (user.getName() == null || user.getName().isBlank()) {
            throw new InvalidUserException("Name is required");
        }

        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new InvalidUserException("Email is required");
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new DuplicateEmailException(
                    "Email already exists: " + user.getEmail()
            );
        }

        return userRepository.save(user);
    }

    // UPDATE USER
    public User updateUser(Long id, User user) {

        if (id == null || id <= 0) {
            throw new InvalidUserException("Invalid user ID");
        }

        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(
                        "User not found with id: " + id
                ));

        if (user.getName() == null || user.getName().isBlank()) {
            throw new InvalidUserException("Name is required");
        }

        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new InvalidUserException("Email is required");
        }

        if (!user.getEmail().equals(existingUser.getEmail())
                && userRepository.existsByEmail(user.getEmail())) {

            throw new DuplicateEmailException(
                    "Email already exists: " + user.getEmail()
            );
        }

        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPhone(user.getPhone());
        existingUser.setPassword(user.getPassword());

        return userRepository.save(existingUser);
    }

    // DELETE USER
    public void deleteUser(Long id) {

        if (id == null || id <= 0) {
            throw new InvalidUserException("Invalid user ID");
        }

        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException(
                    "User not found with id: " + id
            );
        }

        userRepository.deleteById(id);
    }
}