package com.finki5.lab2.Repository;

import com.finki5.lab2.Model.Author;
import com.finki5.lab2.Model.Book;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAll();
    Optional<Book> findByName(String name);
    List<Book> findAllByAuthor(Author author);
    Optional<Book> findById(Long id);

}
