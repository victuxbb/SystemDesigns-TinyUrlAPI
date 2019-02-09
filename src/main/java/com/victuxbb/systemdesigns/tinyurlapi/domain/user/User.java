package com.victuxbb.systemdesigns.tinyurlapi.domain.user;

import java.time.LocalDateTime;

public class User {
    private Integer id;
    private String name;
    private String email;
    private LocalDateTime creationDate;
    private LocalDateTime lastLogin;

    public User(Integer id, String name, String email, LocalDateTime creationDate, LocalDateTime lastLogin) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.creationDate = creationDate;
        this.lastLogin = lastLogin;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }
}
