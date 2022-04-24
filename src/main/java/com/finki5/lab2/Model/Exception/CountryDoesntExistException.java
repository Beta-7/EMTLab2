package com.finki5.lab2.Model.Exception;

public class CountryDoesntExistException extends RuntimeException {
    public CountryDoesntExistException(String country) {
        super ("Country with name " + country + "doesn't exist");
    }
}
