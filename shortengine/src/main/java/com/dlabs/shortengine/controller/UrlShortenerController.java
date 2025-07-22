package com.dlabs.shortengine.controller;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dlabs.shortengine.service.UrlShortenerService;

@RestController
public class UrlShortenerController {
    private static final Logger logger = LoggerFactory.getLogger(UrlShortenerController.class);
    @Autowired
    private UrlShortenerService service;

    @PostMapping("/shorten")
    public ResponseEntity<String> shortenUrl(@RequestBody String longUrl) {
        System.out.println("Received long URL: " + longUrl);
        String code = service.shortenUrl(longUrl);
        return ResponseEntity.ok("http://localhost:3333/shortengine/" + code);
    }

    @GetMapping("/{code}")
    public ResponseEntity<Void> redirect(@PathVariable String code) {
        String originalUrl = service.getOriginalUrl(code);
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(originalUrl))
                .build();
    }

    @GetMapping("/test")
    public ResponseEntity<Void> ion() {
        // log some infor
        // uaing logger
        logger.info("Test endpoint hit");
        return ResponseEntity.ok().build();

    }
}
