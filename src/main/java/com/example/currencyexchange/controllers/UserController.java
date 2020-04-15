package com.example.currencyexchange.controllers;

import com.example.currencyexchange.dto.UserRegistrationDto;
import com.example.currencyexchange.service.AuthenticateService;
import com.example.currencyexchange.service.PersonService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

    @Autowired
    private MessageSource messageSource;

    @PostMapping("/create")
    public String createUser(@Valid @ModelAttribute(value = "user") UserRegistrationDto user,
                             BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("error",
                    messageSource.getMessage(bindingResult.getFieldError(), null));
            return "error";
        }
        authenticateService.registrate(user);
        return "index";
    }

    @GetMapping("/create")
    public String showCreateUser(Model model) {
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
