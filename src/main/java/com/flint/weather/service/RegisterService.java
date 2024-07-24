package com.flint.weather.service;

import com.flint.weather.dto.UserRegistration;
import com.flint.weather.entity.Role;
import com.flint.weather.entity.User;
import com.flint.weather.repository.RoleRepository;
import com.flint.weather.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegisterService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public void saveUser(UserRegistration userRegistration){
        userRepository.save(buildUser(userRegistration));
    }

    public User buildUser(UserRegistration userRegistration){
        User user = new User();
        user.setName(userRegistration.getFirstName() + " " +userRegistration.getLastName());
        user.setEmail(userRegistration.getEmail());
        user.setPassword(passwordEncoder.encode(userRegistration.getPassword()));
        log.info("save data user in bd");

        Role role = roleRepository.findByName("ROLE_ADMIN");
        if(role == null){
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        return user;
    }

    private Role checkRoleExist(){
        Role role = new Role();
        role.setName("ROLE_ADMIN");

        return roleRepository.save(role);
    }
}
