package pl.coderslab.spotify.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spotify.entity.Album;
import pl.coderslab.spotify.repository.AlbumRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/album")
public class AlbumController {

    private final AlbumRepository albumRepository;

    public AlbumController(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    //addAlbum
    @GetMapping("/add")
    public String showFormUser(Model model) {
        model.addAttribute("album", new Album());
        return "album/add";
    }

    @PostMapping("/add")

    public String perform(@ModelAttribute @Valid Album album, BindingResult result) {
        if (result.hasErrors()) {
            return "album/add";
        }
        albumRepository.save(album);
        return "redirect:/album/showAll";

    }



    //listAlbums

    @GetMapping("/showAll")
    public String toString(Model model) {
        model.addAttribute("albums", albumRepository.findAll());
        return "album/showAll";
    }

}
