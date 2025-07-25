package com.dlabs.shortengine.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UrlMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String originalUrl;
    private String shortCode;
    private LocalDateTime createdAt;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getOriginalUrl() {
        return originalUrl;
    }
    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }
    public String getShortCode() {
        return shortCode;
    }
    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
