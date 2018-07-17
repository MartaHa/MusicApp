package pl.coderslab.spotify.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spotify.entity.Author;
import pl.coderslab.spotify.repository.AuthorRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    //addCategory


    //add
    @GetMapping("/add")
    public String showFormUser(Model model) {
        model.addAttribute("author", new Author());
        return "author/add";
    }

    @PostMapping("/add")

    public String perform(@ModelAttribute @Valid Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "author/add";
        }
        authorRepository.save(author);
        return "redirect:/author/showAll";

    }

    //listAuthors

    @GetMapping("/showAll")
    public String toString(Model model) {
        model.addAttribute("authors", authorRepository.findAll());
        return "author/showAll";
    }



    //updateAuthor

    @GetMapping("/update/{id}")
    public String updateAuthor(Model model, @PathVariable long id) {
        model.addAttribute("author", authorRepository.findById(id));
        return "author/updateAuthor";
    }

    @PostMapping("/update")
    public String performUpdate(@ModelAttribute @Valid Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "author/updateAuthor";
        }
        authorRepository.save(author);
        return "redirect:/author/showAll";

    }
}
