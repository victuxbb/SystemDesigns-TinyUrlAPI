package com.victuxbb.systemdesigns.tinyurlapi.domain.shorturl;

import java.time.LocalDateTime;

public class ShortUrl {
    private String hash;
    private String originalURL;
    private LocalDateTime creationDate;

    public ShortUrl(String hash, String originalURL, LocalDateTime creationDate) {
        this.hash = hash;
        this.originalURL = originalURL;
        this.creationDate = creationDate;
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
}
