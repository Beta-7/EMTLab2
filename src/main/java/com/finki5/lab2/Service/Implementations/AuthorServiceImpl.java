package com.finki5.lab2.Service.Implementations;

import com.finki5.lab2.Model.Author;
import com.finki5.lab2.Model.Country;
import com.finki5.lab2.Model.Exception.CountryDoesntExistException;
import com.finki5.lab2.Repository.AuthorRepository;
import com.finki5.lab2.Repository.CountryRepository;
import com.finki5.lab2.Service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public Author save(Author author) {
        if(author != null){
            this.authorRepository.save(author);
        }
        return author;
    }
    @Override
    public Author save(String name, String surname, String country){
        Optional<Country> cnt = countryRepository.findByNameLike(country);
        if(cnt.isEmpty()){
            throw new CountryDoesntExistException(country);
        }
        Author author = new Author(name, surname, cnt.get());
        return author;
    }

    @Override
    public Author save(String name, String surname, Long countryid) {
        Optional<Country> cnt = countryRepository.findById(countryid);
        if(cnt.isEmpty()){
            throw new CountryDoesntExistException(Long.toString(countryid));
        }

        Author author = this.authorRepository.save(new Author(name, surname, cnt.get()));
        return author;
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findByNameAndSurname(String name, String surname) {
        return this.authorRepository.findByNameAndSurnameLike(name, surname);
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);
    }


}
