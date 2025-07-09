package com.dlabs.shortengine.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.dlabs.shortengine.model.UrlMapping;
import com.dlabs.shortengine.repository.UrlMappingRepository;

@Service
public class UrlShortenerService {
    
    @Autowired
    private UrlMappingRepository repository;

    public String shortenUrl(String originalUrl) {
        String code = generateShortCode();
        UrlMapping mapping = new UrlMapping();
        mapping.setOriginalUrl(originalUrl);
        mapping.setShortCode(code);
        mapping.setCreatedAt(LocalDateTime.now());

        repository.save(mapping);
        return code;
    }

    public String getOriginalUrl(String shortCode) {
        return repository.findByShortCode(shortCode)
                .map(UrlMapping::getOriginalUrl)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Short URL not found"));

    }

    private String generateShortCode() {
        return UUID.randomUUID().toString().substring(0, 6); // Simple version
    }
}
