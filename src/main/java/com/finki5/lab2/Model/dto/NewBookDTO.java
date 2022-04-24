package com.finki5.lab2.Model.dto;

import lombok.Data;

//RequestBody String name, @RequestBody String category, @RequestBody Long authorId, @RequestBody int availableCopies
@Data
public class NewBookDTO {
    private String name;
    private String category;
    private Long authorId;
    private int availableCopies;

    public NewBookDTO() {
    }

    public NewBookDTO(String name, String category, Long authorId, int availableCopies) {
        this.name = name;
        this.category = category;
        this.authorId = authorId;
        this.availableCopies = availableCopies;
    }

}
