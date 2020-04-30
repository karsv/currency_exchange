package com.example.currencyexchange.controllers;

import com.example.currencyexchange.dto.UserRegistrationDto;
import com.example.currencyexchange.service.AuthenticateService;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class InitController {
    private final AuthenticateService authenticateService;

    public InitController(AuthenticateService authenticateService) {
        this.authenticateService = authenticateService;
    }

    @PostConstruct
    private void initController() {
        UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
        userRegistrationDto.setName("admin");
        userRegistrationDto.setPassword("123");
        authenticateService.registrate(userRegistrationDto);
    }
}
