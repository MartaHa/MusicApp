package pl.coderslab.spotify.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spotify.entity.User;
import pl.coderslab.spotify.repository.UserRepository;
import pl.coderslab.spotify.services.CurrentUser;
import pl.coderslab.spotify.services.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserRepository userRepository;
    private final UserService userService;

    public AdminController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }



    //updateAdmin
    @GetMapping("/update")
    public String showFormUser(Model model, @AuthenticationPrincipal CurrentUser customUser) {
        model.addAttribute("user", customUser.getUser());
        return "admin/update";
    }

    @PostMapping("/update")
    public String performUpdate(@ModelAttribute User user, @AuthenticationPrincipal CurrentUser customUser) {
        userRepository.save(user);
        return "redirect:/welcomeAd";
    }

    //showUser

    @GetMapping("/showUser")

    public String showOne(Model model, @RequestParam Long id) {
        model.addAttribute("users", userRepository.getOne(id));
        return "user/showUser";

    }

}
