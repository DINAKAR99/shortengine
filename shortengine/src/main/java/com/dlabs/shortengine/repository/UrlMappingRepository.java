package com.dlabs.shortengine.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dlabs.shortengine.model.UrlMapping;

public interface UrlMappingRepository extends JpaRepository<UrlMapping, Long> {
    Optional<UrlMapping> findByShortCode(String shortCode);
}
