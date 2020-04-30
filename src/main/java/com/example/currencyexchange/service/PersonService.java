package com.example.currencyexchange.service;

import com.example.currencyexchange.model.Person;
import java.util.List;

public interface PersonService {
    Person add(Person person);

    Person getUserById(Long id);

    Person getUserByName(String name);

    List<Person> getAllUsers();

    boolean checkNameIfExists(String name);
}
