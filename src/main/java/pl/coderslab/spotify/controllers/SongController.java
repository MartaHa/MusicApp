package pl.coderslab.spotify.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.spotify.entity.Author;
import pl.coderslab.spotify.entity.Category;
import pl.coderslab.spotify.entity.Song;
import pl.coderslab.spotify.repository.AuthorRepository;
import pl.coderslab.spotify.repository.CategoryRepository;
import pl.coderslab.spotify.repository.SongRepository;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/song")
public class SongController {

    private final SongRepository songRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;

    public SongController(SongRepository songRepository, AuthorRepository authorRepository, CategoryRepository categoryRepository) {
        this.songRepository = songRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
    }

    //add
    @GetMapping("/add")
    public String showFormUser(Model model) {
        model.addAttribute("song", new Song());
        return "song/add";
    }

    @PostMapping("/add")

    public String perform(@ModelAttribute @Valid Song song, BindingResult result) {
        if (result.hasErrors()) {
            return "song/add";
        }

        songRepository.save(song);
        return "redirect:/listSongs";

    }

    //addAuthor

    @ModelAttribute("authors")
    public Collection<Author> populateAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authors;
    }

//addCategoryToSong

    @ModelAttribute("categories")
    public Collection<Category> populateCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }


    //listOfSongs

    @GetMapping("/showAll")
    public String toString(Model model) {
        model.addAttribute("songs", songRepository.findAll());
        return "song/showAll";
    }
}
