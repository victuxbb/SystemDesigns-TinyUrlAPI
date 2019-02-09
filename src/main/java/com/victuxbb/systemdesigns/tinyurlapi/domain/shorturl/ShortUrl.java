package com.victuxbb.systemdesigns.tinyurlapi.domain.shorturl;

import com.victuxbb.systemdesigns.tinyurlapi.domain.user.User;

import java.time.LocalDateTime;

public class ShortUrl {
    private String hash;
    private String originalURL;
    private LocalDateTime creationDate;
    private LocalDateTime expirationDate;
    private User user;

    public ShortUrl(String hash, String originalURL, LocalDateTime creationDate, LocalDateTime expirationDate, User user) {
        this.hash = hash;
        this.originalURL = originalURL;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
        this.user = user;
    }

    public String getHash() {
        return hash;
    }

    public String getOriginalURL() {
        return originalURL;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public User getUser() {
        return user;
    }
}
