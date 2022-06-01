package com.kepco.etax.api.repository;

import com.kepco.etax.api.domain.Book;
import com.kepco.etax.api.domain.Lend;
import com.kepco.etax.api.domain.LendStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LendRepository extends JpaRepository<Lend, Long> {
    Optional<Lend> findByBookAndStatus(Book book, LendStatus status);
}
