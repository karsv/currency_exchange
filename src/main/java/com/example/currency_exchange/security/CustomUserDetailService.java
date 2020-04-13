package com.example.currency_exchange.security;

import com.example.currency_exchange.model.Person;
import com.example.currency_exchange.service.PersonService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private final PersonService personService;

    public CustomUserDetailService(PersonService userService) {
        this.personService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Person user = personService.getUserByName(name);
        org.springframework.security.core.userdetails.User.UserBuilder userBuilder =
                User.withUsername(name);
        userBuilder.password(user.getPassword());
        userBuilder.roles(user.getRole());
        return userBuilder.build();
    }
}
