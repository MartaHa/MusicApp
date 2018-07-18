package pl.coderslab.spotify.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spotify.entity.*;
import pl.coderslab.spotify.repository.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/song")
public class SongController {

    private final SongRepository songRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final AlbumRepository albumRepository;
    private final LyricsRepository lyricsRepository;

    public SongController(SongRepository songRepository, AuthorRepository authorRepository, CategoryRepository categoryRepository, AlbumRepository albumRepository, LyricsRepository lyricsRepository) {
        this.songRepository = songRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
        this.albumRepository = albumRepository;
        this.lyricsRepository = lyricsRepository;
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
        return "redirect:/song/listSongs";

    }

    //addAuthor

    @ModelAttribute("authors")
    public Collection<Author> populateAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authors;
    }


    //addAlbums

    @ModelAttribute("albums")
    public Collection<Album> populateAlbums() {
        List<Album> albums = albumRepository.findAll();
        return albums;
    }

//addCategoryToSong

    @ModelAttribute("categories")
    public Collection<Category> populateCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }


    //addLyricsToSong

    @ModelAttribute("lyrics")
    public Collection<Lyrics> populateLyrics() {
        List<Lyrics> lyrics = lyricsRepository.findAll();
        return lyrics;
    }

    //listOfSongs

    @GetMapping("/listSongs")
    public String toString(Model model) {
        model.addAttribute("songs", songRepository.findAll());
        return "song/showAll";
    }


//byCategory

    @GetMapping("/byCategory")

    public String findByCategory(@RequestParam String category, Model model) {
        long id = categoryRepository.findSongsbyCategory(category);
        List<Song> songs = songRepository.findSongsbyCategory(id);
        model.addAttribute("songs", songs);
        return "song/viewSongsbySearch";
    }


    //byRating

    @GetMapping("/byRating")

    public String findByRating(@RequestParam String rating, Model model) {
        List<Song> songs = songRepository.findSongByRating(rating);
        model.addAttribute("songs", songs);
        return "song/viewSongsbySearch";
    }
}