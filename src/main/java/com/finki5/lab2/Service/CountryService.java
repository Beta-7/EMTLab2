package com.finki5.lab2.Service;

import com.finki5.lab2.Model.Country;

import java.util.List;

public interface CountryService {
    Country save(Country country);
    List<Country> getAll();
}
