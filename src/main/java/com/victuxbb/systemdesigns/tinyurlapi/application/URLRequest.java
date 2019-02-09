package com.victuxbb.systemdesigns.tinyurlapi.application;

import java.time.LocalDateTime;

public class URLRequest {
    private String originalURL;
    private String customAlias;
    private String username;
    private LocalDateTime expireDate;

    public URLRequest(String originalURL, String customAlias, String username, LocalDateTime expireDate) {
        this.originalURL = originalURL;
        this.customAlias = customAlias;
        this.username = username;
        this.expireDate = expireDate;
    }

    public String getOriginalURL() {
        return originalURL;
    }

    public String getCustomAlias() {
        return customAlias;
    }

    public String getUsername() {
        return username;
    }

    public LocalDateTime getExpireDate() {
        return expireDate;
    }
}
