package com.finki5.lab2.Model.Exception;

public class AuthorDoesntExistException extends RuntimeException {
    public AuthorDoesntExistException(String authorName, String authorSurname) {
    super("Author with name "+authorName+" "+authorSurname+" doesn't exist");
    }
}
