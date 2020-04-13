package com.example.currency_exchange.controllers;

import com.example.currency_exchange.dto.UserRegistrationDto;
import com.example.currency_exchange.model.Person;
import com.example.currency_exchange.service.AuthenticateService;
import com.example.currency_exchange.service.PersonService;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    private final PersonService userService;
    private final AuthenticateService authenticateService;

    public UserController(PersonService userService, AuthenticateService authenticateService) {
        this.userService = userService;
        this.authenticateService = authenticateService;
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute(value = "user") UserRegistrationDto user) {
        authenticateService.registrate(user);
        return "index";
    }

    @GetMapping("/create")
    public String showCreateUser(Model model){
        UserRegistrationDto person = new UserRegistrationDto();
        model.addAttribute("user", person);
        return "create";
    }

    @GetMapping("/show-all-users")
    public String getUsers(Model model) {
        model.addAttribute("persons", userService.getAllUsers());
        return "users";
    }
}
