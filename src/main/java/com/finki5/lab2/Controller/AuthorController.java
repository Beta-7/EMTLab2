package com.finki5.lab2.Controller;


import com.finki5.lab2.Model.Author;
import com.finki5.lab2.Model.Country;
import com.finki5.lab2.Model.dto.NewAuthorDTO;
import com.finki5.lab2.Service.AuthorService;
import com.finki5.lab2.Service.CountryService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAll(){
        return authorService.getAll();
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public Author addAuthor(@RequestBody NewAuthorDTO newAuthorDTO){
        System.out.println(newAuthorDTO);
        Author savedAuthor = this.authorService.save(newAuthorDTO.getName(), newAuthorDTO.getSurname(), newAuthorDTO.getCountryId());
        return savedAuthor;
    }
}
