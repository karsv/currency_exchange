package com.example.currency_exchange.service.impl;

import com.example.currency_exchange.exceptions.UserException;
import com.example.currency_exchange.model.Person;
import com.example.currency_exchange.repository.PersonRepository;
import com.example.currency_exchange.service.PersonService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository userRepository) {
        this.personRepository = userRepository;
    }

    @Override
    public Person add(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person getUserById(Long id) {
        Optional<Person> user = personRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserException("No user with such Id!");
        }
        return user.get();
    }

    @Override
    public Person getUserByName(String name) {
        Optional<Person> user = personRepository.findByName(name);
        if (user.isEmpty()) {
            throw new UserException("No user with such name!");
        }
        return user.get();
    }

    @Override
    public List<Person> getAllUsers() {
        return personRepository.findAll();
    }

    @Override
    public boolean checkNameIfExists(String name) {
        return personRepository.existsByName(name);
    }
}
