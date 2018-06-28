package pl.coderslab.spotify.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    //add
    @GetMapping("/addAdmin")
    public String showFormUser(Model model) {
        model.addAttribute("user", new User());
        return "admin/registerAdmin";
    }

    @PostMapping("/addAdmin")

    public String perform(@ModelAttribute @Valid User user, String role, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/registerAdmin";
        }
        userService.saveUser(user, "ROLE_ADMIN");
        return "redirect:/login";

    }

    //updateAdmin
    @GetMapping("/update")
    public String showFormUser(Model model, @AuthenticationPrincipal CurrentUser customUser) {
        model.addAttribute("user", customUser.getUser());
        return "admin/updateUser";
    }

    @PostMapping("/update")
    public String performUpdate(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/showUser";
    }

}
