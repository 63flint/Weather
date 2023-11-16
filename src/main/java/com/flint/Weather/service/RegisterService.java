package com.flint.Weather.service;

import com.flint.Weather.model.users.User;
import com.flint.Weather.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterService {
    public final UserRepository userRepository;

    public void saveUser(){
        userRepository.save(buildUser());
    }

    public User buildUser(){
        User user = new User();
        user.setId(100);
        user.setName("Alex");
        user.setEmail("alex@mail.ru");
        user.setPassword("test");
        return user;
    }
}
