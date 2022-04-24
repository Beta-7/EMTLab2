package com.finki5.lab2.Model;

import com.finki5.lab2.Model.enums.BookCategoryEnum;
import com.finki5.lab2.Repository.AuthorRepository;
import com.finki5.lab2.Repository.BookRepository;
import com.finki5.lab2.Repository.CountryRepository;
import org.springframework.stereotype.Component;

@Component
public class DataFiller {

    private final CountryRepository countryRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public DataFiller(CountryRepository countryRepository, AuthorRepository authorRepository, BookRepository bookRepository){

        this.countryRepository = countryRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.fillData();
    }

    private void fillData(){
        Country england = new Country("England", "Europe");
        Country macedonia = new Country("Macedonia", "Europe");
        Country US = new Country("USA", "North America");

        countryRepository.save(england);
        countryRepository.save(macedonia);
        countryRepository.save(US);

        Author shakespear = new Author("William","Shakespear",england);
        Author vojdan = new Author("Војдан", "Чернодрински", macedonia);
        Author hemingvej = new Author("Ernest", "Hemingway", US);

        authorRepository.save(shakespear);
        authorRepository.save(vojdan);
        authorRepository.save(hemingvej);

        Book rnj = new Book("Romeo & Julliet", BookCategoryEnum.CLASSICS,shakespear,50);
        Book mks = new Book("Македонска Крвава Свадба", BookCategoryEnum.DRAMA, vojdan, 100);
        Book uk = new Book("Under Kilimanjaro",BookCategoryEnum.NOVEL, hemingvej, 15);

        bookRepository.save(rnj);
        bookRepository.save(mks);
        bookRepository.save(uk);
    }
}
