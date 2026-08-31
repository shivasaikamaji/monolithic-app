package com.example.demo.user.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.user.entity.User;
import com.example.demo.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // GET all users
    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    // GET user by ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // CREATE user
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // UPDATE user
    @PutMapping("/{id}")
    public User updateUser(
            @PathVariable Long id,
            @RequestBody User user) {

        return userService.updateUser(id, user);
    }

    // DELETE user
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);

        return "User deleted successfully"; 
    }
}