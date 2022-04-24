package com.finki5.lab2.Controller;

import com.finki5.lab2.Model.Book;
import com.finki5.lab2.Model.enums.BookCategoryEnum;
import com.finki5.lab2.Model.dto.NewBookDTO;
import com.finki5.lab2.Repository.AuthorRepository;
import com.finki5.lab2.Repository.BookRepository;
import com.finki5.lab2.Repository.CountryRepository;
import com.finki5.lab2.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;
    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;

    private final CountryRepository countryRepository;

    @Autowired
    public BookController(BookService bookService, BookRepository bookRepository, AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @GetMapping
    public List<Book> findAll(){
        return this.bookService.getAllBooks();
    }

    @GetMapping("/categories")
    public List<BookCategoryEnum> categories(){
        return Arrays.asList(BookCategoryEnum.values());
//        return "asd";
    }



    @GetMapping("/rent/{id}")
    public int rent(@PathVariable Long id){
            this.bookService.updateAvailableCopiesMinusOne(id);
            return this.bookService.getBookById(id).get().getAvailableCopies();
    }
    @GetMapping("/return/{id}")
    public int borrow(@PathVariable Long id){
        this.bookService.updateAvailableCopiesPlusOne(id);
        return this.bookService.getBookById(id).get().getAvailableCopies();
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
            this.bookService.deleteBook(id);
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public Book addBook(@RequestBody NewBookDTO NewBookDTO){
        Book book = this.bookService.addBook(NewBookDTO.getName(), BookCategoryEnum.valueOf(NewBookDTO.getCategory()), NewBookDTO.getAuthorId(), NewBookDTO.getAvailableCopies());
        return book;
    }




    @PostMapping("/{id}")
    public Book update(@PathVariable Long id, @RequestBody NewBookDTO newBookDTO){
        return this.bookService.editBook(id, newBookDTO.getName(), BookCategoryEnum.valueOf(newBookDTO.getCategory()),newBookDTO.getAuthorId(), newBookDTO.getAvailableCopies());


    }

}
