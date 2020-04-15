package com.example.currencyexchange.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRegistrationDto {
    @NotNull(message = "Can't be Null!")
    @Size(min = 3, message = "The name should be more than 3 characters!")
    private String name;
    @NotNull(message = "Can't be Null!")
    @Size(min = 3, message = "The password should be more than 3 characters!")
    private String password;
}
