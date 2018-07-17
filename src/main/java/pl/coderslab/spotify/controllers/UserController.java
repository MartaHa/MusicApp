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
@RequestMapping("/user")
public class UserController {


    private final UserRepository userRepository;
    private final UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }



    //updateUser
    @GetMapping("/update/{id}")
    public String showFormUser(Model model, @PathVariable long id) {
        model.addAttribute("user", userRepository.findById(id));
        return "user/update";
    }

    @PostMapping("/update")
    public String performUpdate(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/showUser";
    }
    @GetMapping("/show")

    public String showUser(@AuthenticationPrincipal CurrentUser customUser, Model model) {
        User entityUser = customUser.getUser();
        model.addAttribute("user", entityUser);
        return "user/showUser";

    }

}
