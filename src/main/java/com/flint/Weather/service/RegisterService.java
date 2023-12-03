package com.flint.Weather.service;

import com.flint.Weather.dto.UserRegistration;
import com.flint.Weather.entity.User;
import com.flint.Weather.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegisterService {
    public final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public void saveUser(UserRegistration userRegistration){
        userRepository.save(buildUser(userRegistration));
    }

    public User buildUser(UserRegistration userRegistration){
        User user = new User();
        user.setName(userRegistration.getFirstName() + " " +userRegistration.getLastName());
        user.setEmail(userRegistration.getEmail());
        user.setPassword(userRegistration.getPassword());
        log.info("save data user in bd");
        return user;
    }
}
