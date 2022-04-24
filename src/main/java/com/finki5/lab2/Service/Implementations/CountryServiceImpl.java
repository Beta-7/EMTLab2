package com.finki5.lab2.Service.Implementations;

import com.finki5.lab2.Model.Country;
import com.finki5.lab2.Repository.CountryRepository;
import com.finki5.lab2.Service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country save(Country country) {
        if(country != null){
            this.countryRepository.save(country);
        }
        return country;
    }


    @Override
    public List<Country> getAll() {
        return countryRepository.findAll();
    }
}
