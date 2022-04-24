package com.finki5.lab2.Controller;


import com.finki5.lab2.Model.Country;
import com.finki5.lab2.Model.dto.NewCountryDTO;
import com.finki5.lab2.Service.CountryService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/country")
public class CountryController {

    final private CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> findAll(){
        return this.countryService.getAll();
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public Country addCountry(@RequestBody NewCountryDTO newCountryDTO){
        Country country =countryService.save(new Country(newCountryDTO.getName(), newCountryDTO.getContinent()));
        return country;
    }
}
