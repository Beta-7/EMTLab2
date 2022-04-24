package com.finki5.lab2.Service;

import com.finki5.lab2.Model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Author save(Author author);

    Author save(String name, String surname, String country);
    Author save(String name, String surname, Long countryid);

    List<Author> getAll();

    Optional<Author> findByNameAndSurname(String name, String surname);
    Optional<Author> findById(Long id);
}
