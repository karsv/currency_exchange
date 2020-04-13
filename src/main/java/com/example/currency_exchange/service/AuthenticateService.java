package com.example.currency_exchange.service;

import com.example.currency_exchange.dto.UserRegistrationDto;
import com.example.currency_exchange.model.Person;

public interface AuthenticateService {
    Person registrate(UserRegistrationDto userRegistrationDto);
}
