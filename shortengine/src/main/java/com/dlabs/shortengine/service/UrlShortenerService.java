package com.dlabs.shortengine.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UrlShortenerService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final String PREFIX = "shorturl:";

    public String shortenUrl(String longUrl) {
        // Generate code (could be any logic)
        String code = generateCode(longUrl);

        // Store code -> url mapping in Redis with an expiration time (optional)
        redisTemplate.opsForValue().set(PREFIX + code, longUrl, 7, TimeUnit.SECONDS);

        return code;
    }

    public String getOriginalUrl(String code) {
        return redisTemplate.opsForValue().get(PREFIX + code);
    }

    private String generateCode(String url) {
        // Simple example: hashcode converted to hex, you can improve this
        return Integer.toHexString(url.hashCode());
    }
}
