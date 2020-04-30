package com.example.currencyexchange.service.impl;

import com.example.currencyexchange.dto.UserRegistrationDto;
import com.example.currencyexchange.exceptions.UserException;
import com.example.currencyexchange.model.Person;
import com.example.currencyexchange.service.AuthenticateService;
import com.example.currencyexchange.service.PersonService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticateServiceImpl implements AuthenticateService {
    private static final String DEFAULT_ROLE = "USER";
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
