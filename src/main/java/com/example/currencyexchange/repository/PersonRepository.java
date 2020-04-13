package com.example.currencyexchange.repository;

import com.example.currencyexchange.model.Person;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByName(String name);

    boolean existsByName(String name);
}
