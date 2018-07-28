package pl.coderslab.spotify.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spotify.entity.Lyrics;
import pl.coderslab.spotify.repository.LyricsRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/lyrics")
public class LyricController {


    public final LyricsRepository lyricsRepository;

    public LyricController(LyricsRepository lyricsRepository) {
        this.lyricsRepository = lyricsRepository;
    }

    //add
    @GetMapping("/add")
    public String showFormUser(Model model) {
        model.addAttribute("lyrics", new Lyrics());
        return "lyrics/add";
    }

    @PostMapping("/add")

    public String perform(@ModelAttribute @Valid Lyrics lyrics, BindingResult result) {
        if (result.hasErrors()) {
            return "lyrics/add";
        }
        lyricsRepository.save(lyrics);
        return "redirect:/lyrics/showAll";

    }

    //listLyrics

    @GetMapping("/showAll")
    public String showAllLyrics(Model model) {
        model.addAttribute("allLyrics", lyricsRepository.findAll());
        return "lyrics/showAll";
    }

    //showOne

    @GetMapping("/showOne/{id}")

    public String showOne(Model model, @PathVariable Long id) {
        model.addAttribute("lyrics", lyricsRepository.getOne(id));
        return "lyrics/showOne";

    }

    //updateLyric

    @GetMapping("/update/{id}")
    public String showForm(Model model, @PathVariable long id) {
        model.addAttribute("lyrics", lyricsRepository.findById(id));
        return "lyrics/update";
    }

    @PostMapping("/update")
    public String performUpdate(@ModelAttribute Lyrics lyrics) {
        lyricsRepository.save(lyrics);
        return "redirect:/lyrics/showAll";

    }

}
