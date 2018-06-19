package pl.coderslab.spotify.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.spotify.entity.User;
import pl.coderslab.spotify.repository.UserRepository;
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

    //add
    @GetMapping("/add")
    public String showFormUser(Model model) {
        model.addAttribute("user", new User());
        return "user/register";
    }

    @PostMapping("/add")

    public String perform(@ModelAttribute @Valid User user, String role, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        userService.saveUser(user, "ROLE_USER");
        return "redirect:/user/login";

    }



}
