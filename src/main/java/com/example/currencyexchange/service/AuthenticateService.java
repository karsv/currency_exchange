package com.example.currencyexchange.service;

import com.example.currencyexchange.dto.UserRegistrationDto;
import com.example.currencyexchange.model.Person;

public interface AuthenticateService {
    Person registrate(UserRegistrationDto userRegistrationDto);
}
