package com.flint.weather.service;

import com.flint.weather.repository.RoleRepository;
import com.flint.weather.repository.UserRepository;
import com.flint.weather.service.RegisterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class RegisterServiceTest {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;
    @Autowired
    private RegisterService registerService;

    @Test
    void name() {
    }
}
