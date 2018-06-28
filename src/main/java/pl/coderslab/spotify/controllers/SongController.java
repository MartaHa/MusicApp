package pl.coderslab.spotify.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.spotify.entity.Song;
import pl.coderslab.spotify.repository.SongRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/song")
public class SongController {

    private final SongRepository songRepository;

    public SongController(SongRepository songRepository) {
        this.songRepository = songRepository;
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

    //listOfSongs

    @GetMapping("/showAll")
    public String toString(Model model) {
        model.addAttribute("songs", songRepository.findAll());
        return "song/showAll";
    }
}
