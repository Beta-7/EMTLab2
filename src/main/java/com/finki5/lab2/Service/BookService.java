package com.finki5.lab2.Service;

import com.finki5.lab2.Model.Author;
import com.finki5.lab2.Model.Book;
import com.finki5.lab2.Model.enums.BookCategoryEnum;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAllBooks();

    Book addBook(Book book);

    Book addBook(String name, BookCategoryEnum category, String authorName, String authorSurname, int availableCopies);

    Book addBook(String name, BookCategoryEnum category, Long authorId, int availableCopies);

    Optional<Book> getBookById(Long id);
    Optional<Book> updateAvailableCopiesPlusOne(Long id);
    Optional<Book> updateAvailableCopiesMinusOne(Long id);


    Book editBook(Long id, String name, BookCategoryEnum category, Long authorId, int availableCopies);

    Optional<Book> deleteBook(Long id);
}
