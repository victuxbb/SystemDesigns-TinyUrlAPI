package com.victuxbb.systemdesigns.tinyurlapi.infrastructure.datasource;

import com.victuxbb.systemdesigns.tinyurlapi.domain.shorturl.ShortURL;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;

@Table("url")
public class URL {
    @PrimaryKeyColumn(name = "hash", type = PrimaryKeyType.PARTITIONED)
    @Id
    private String hash;
    @Column("original_url")
    private String originalURL;
    @Column("creation_date")
    private LocalDateTime creationDate;

    public URL() {
    }

    URL(ShortURL shortUrl) {
        hash = shortUrl.getHash();
        originalURL = shortUrl.getOriginalURL();
        creationDate = shortUrl.getCreationDate();
    }

    public URL(String hash, String originalURL, LocalDateTime creationDate) {
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

    ShortURL toShortURL() {
        return new ShortURL(hash, originalURL, creationDate);
    }
}
