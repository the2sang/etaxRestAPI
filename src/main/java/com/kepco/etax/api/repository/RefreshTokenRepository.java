package com.kepco.etax.api.repository;

import com.kepco.etax.api.domain.entity.security.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {

    Optional<RefreshToken> findByKey(Long key);
}

