package com.finki5.lab2.Model.Exception;

public class NoBookWithThatIdException extends RuntimeException{
        public NoBookWithThatIdException(Long id) {
            super("No book with that Id exception " +id);

    }

}
