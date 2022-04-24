package com.finki5.lab2.Model.dto;

import lombok.Data;

@Data
public class NewCountryDTO {
    private String name;

    private String continent;

    public NewCountryDTO(String name, String continent) {
        this.name = name;
        this.continent = continent;
    }
}
