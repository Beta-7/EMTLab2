package com.finki5.lab2.Model;

import com.finki5.lab2.Model.enums.BookCategoryEnum;
import lombok.Data;

import javax.persistence.*;



@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.ORDINAL)
    private BookCategoryEnum category;

    @ManyToOne
    private Author author;

    private int availableCopies;

    public Book() {
    }

    public Book(String name, BookCategoryEnum category, Author author, int availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public Book(String name, BookCategoryEnum category, int availableCopies) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.availableCopies = availableCopies;
    }
}
