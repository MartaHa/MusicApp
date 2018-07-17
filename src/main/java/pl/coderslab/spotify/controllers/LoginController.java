package pl.coderslab.spotify.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.spotify.entity.User;
import pl.coderslab.spotify.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class LoginController {


    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }


    //addUser


    @GetMapping("/add")
    public String showFormUser(Model model) {
        model.addAttribute("user", new User());
        return "registerUser";
    }

    @PostMapping("/add")

    public String perform(@ModelAttribute @Valid User user, String role, BindingResult result) {
        if (result.hasErrors()) {
            return "registerUser";
        }
        userService.saveUser(user, "ROLE_USER");
        return "redirect:/login";

    }


    //addAdmin
    @GetMapping("/registerAdmin")
    public String showFormAdmin(Model model) {
        model.addAttribute("user", new User());
        return "registerAdmin";
    }

    @PostMapping("/registerAdmin")

    public String performAdmin(@ModelAttribute @Valid User user, String role, BindingResult result) {
        if (result.hasErrors()) {
            return "registerAdmin";
        }
        userService.saveUser(user, "ROLE_ADMIN");
        return "redirect:/login";

    }


    //login
    @GetMapping("/login")
    public String Login() {
        return "login";
    }

    @GetMapping("/checkrole")

    public String loginPage(HttpServletRequest httpServletRequest) {
        if (httpServletRequest.isUserInRole("ADMIN")) {
            return "redirect:/welcomeAd";
        } else if (httpServletRequest.isUserInRole("USER")) {
            return "redirect:/welcome";
        }
        return "redirect:/";
    }


    @GetMapping("/welcome")
    public String welcomeUser() {
        return "user/mainUser";
    }

    @GetMapping("/welcomeAd")
    public String welcomeAdmin() {
        return "admin/mainAdmin";
    }
}