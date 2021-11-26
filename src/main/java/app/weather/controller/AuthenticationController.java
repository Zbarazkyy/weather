package app.weather.controller;

import app.weather.dto.model.UserRequestDto;
import app.weather.service.AuthenticationService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuthenticationController {
    private AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public String register(@RequestBody @Valid UserRequestDto requestDto) {
        authenticationService.register(requestDto.getName(), requestDto.getPassword());
        return "weather";
    }
}
