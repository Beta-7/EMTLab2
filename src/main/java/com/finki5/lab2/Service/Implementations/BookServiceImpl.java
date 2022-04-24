package com.finki5.lab2.Service.Implementations;

import com.finki5.lab2.Model.Author;
import com.finki5.lab2.Model.Book;
import com.finki5.lab2.Model.Exception.AuthorDoesntExistException;
import com.finki5.lab2.Model.Exception.NoBookWithThatIdException;
import com.finki5.lab2.Model.Exception.NoAvailableCopies;
import com.finki5.lab2.Model.enums.BookCategoryEnum;
import com.finki5.lab2.Repository.AuthorRepository;
import com.finki5.lab2.Repository.BookRepository;
import com.finki5.lab2.Service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }
    @Override
    public List<Book> getAllBooks(){
       return bookRepository.findAll();
    }

    public List<Book> getBooksByAuthor(Author author){
        return bookRepository.findAllByAuthor(author);
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }


    @Override
    public Optional<Book> updateAvailableCopiesPlusOne(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if(book.isEmpty()){
            throw new NoBookWithThatIdException(id);
        }

        book.get().setAvailableCopies(book.get().getAvailableCopies()+1);
        bookRepository.save(book.get());
        return Optional.of(book.get());
    }

    @Override
    public Optional<Book> updateAvailableCopiesMinusOne(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if(book.isEmpty()){
            throw new NoBookWithThatIdException(id);
        }
        if(book.get().getAvailableCopies()==0){
            throw new NoAvailableCopies(id);
        }
        book.get().setAvailableCopies(book.get().getAvailableCopies()-1);
        bookRepository.save(book.get());
        return Optional.of(book.get());
    }

    @Override
    public Book editBook(Long id, String name, BookCategoryEnum category, Long authorId, int availableCopies) {
        Optional<Book> optbook = this.bookRepository.findById(id);
        Optional<Author> author = this.authorRepository.findById(authorId);
        if(optbook.isEmpty()){
            throw new NoBookWithThatIdException(id);
        }
        if(author.isEmpty()){
            throw new AuthorDoesntExistException("","");
        }
        Book book = optbook.get();
        book.setName(name);
        book.setCategory(category);
        book.setAuthor(author.get());
        book.setAvailableCopies(availableCopies);
        this.bookRepository.save(book);
        return book;
    }

    @Override
    public Optional<Book> deleteBook(Long id) {
        Optional<Book> book = this.bookRepository.findById(id);

        this.bookRepository.deleteById(id);
        return Optional.of(book.get());
    }

    @Override
    public Book addBook(Book book){
        Book savedBook = bookRepository.save(book);
        return savedBook;
    }

    @Override
    public Book addBook(String name, BookCategoryEnum category, String authorName, String authorSurname, int availableCopies) {
        Optional<Author> author = this.authorRepository.findByNameAndSurnameLike(authorName,authorSurname);

        if(author.isEmpty()){
            throw new AuthorDoesntExistException(authorName,authorSurname);
        }

        Book book = new Book(name, category, author.get(),availableCopies);
        return this.bookRepository.save(book);
    }

    @Override
    public Book addBook(String name, BookCategoryEnum category, Long authorId, int availableCopies) {
        Optional<Author> author = this.authorRepository.findById(authorId);

        if(author.isEmpty()){
            throw new AuthorDoesntExistException("","");
        }

        Book book = new Book(name, category, author.get(),availableCopies);
        return this.bookRepository.save(book);
    }

}
