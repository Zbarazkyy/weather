package app.weather.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomePage {
    @GetMapping("/")
    public String walcome(Model model) {
        return "welcome";
    }
}
