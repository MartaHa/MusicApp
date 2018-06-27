package pl.coderslab.spotify.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {


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