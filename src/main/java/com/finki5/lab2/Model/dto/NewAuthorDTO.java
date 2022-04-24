package com.finki5.lab2.Model.dto;

import lombok.Data;

@Data
public class NewAuthorDTO {

    private String name;
    private String surname;
    private Long countryId;

    public NewAuthorDTO(String name, String surname, Long countryId) {
        this.name = name;
        this.surname = surname;
        this.countryId = countryId;
    }
}
