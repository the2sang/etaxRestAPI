package com.kepco.etax.api.repository;

import com.kepco.etax.api.domain.entity.EtaxUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EtaxUserRepository extends JpaRepository<EtaxUser, Long> {

    List<EtaxUser> findByName(String name);

    Optional<EtaxUser> findByEmail(String email);

    Optional<EtaxUser> findByUsername(String username);

    Optional<EtaxUser> findByEmailAndProvider(String email, String provider);
}

