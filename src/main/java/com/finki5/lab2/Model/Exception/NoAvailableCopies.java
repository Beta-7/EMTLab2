package com.finki5.lab2.Model.Exception;

public class NoAvailableCopies extends RuntimeException{
    public NoAvailableCopies(Long id) {
        super("No available copies of book with that Id exception " +id);

    }

}
