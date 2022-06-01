package com.kepco.etax.api.repository;


import com.kepco.etax.api.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
