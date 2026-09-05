package com.example.demo.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UpdateUserRequest {

    @NotNull(message = "Name cannot be null")
    private String name;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Invalid email format")
    private String email;

    @NotNull(message = "Phone cannot be null")
    @Pattern(
        regexp = "^[0-9]{10}$",
        message = "Phone must contain exactly 10 digits"
    )
    private String phone;

    @NotNull(message = "Password cannot be null")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    public UpdateUserRequest() {
    }

    public UpdateUserRequest(String name, String email, String phone, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}