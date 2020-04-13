package com.example.currency_exchange.service.impl;

import com.example.currency_exchange.dto.UserRegistrationDto;
import com.example.currency_exchange.exceptions.UserException;
import com.example.currency_exchange.model.Person;
import com.example.currency_exchange.service.AuthenticateService;
import com.example.currency_exchange.service.PersonService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticateServiceImpl implements AuthenticateService {
    private final static String DEFAULT_ROLE = "USER";
    private final PersonService personService;
    private final PasswordEncoder passwordEncoder;

    public AuthenticateServiceImpl(PersonService personService, PasswordEncoder passwordEncoder) {
        this.personService = personService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Person registrate(UserRegistrationDto userRegistrationDto) {
        if (personService.checkNameIfExists(userRegistrationDto.getName())) {
            throw new UserException("There is user with such name!");
        }
        Person newUser = new Person();
        newUser.setName(userRegistrationDto.getName());
        newUser.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));
        newUser.setRole(DEFAULT_ROLE);
        return personService.add(newUser);
    }
}
