package com.finki5.lab2.Repository;

import com.finki5.lab2.Model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {
        Optional<Country> findByNameLike(String name);
}
