package com.lucio.crmspring.dto;

import com.lucio.crmspring.models.User;

public class LoginResponse {
    private String message;
    private User user;
    private String token;

    // Getters et setters
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
}
