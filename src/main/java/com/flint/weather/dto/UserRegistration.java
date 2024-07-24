package com.flint.weather.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRegistration {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
