package com.finki5.lab2.Repository;

import com.finki5.lab2.Model.Author;
import com.finki5.lab2.Model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByNameAndSurnameLike(String name, String surname);
}
