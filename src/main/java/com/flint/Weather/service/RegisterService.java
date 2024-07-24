package com.flint.Weather.service;

import com.flint.Weather.dto.UserRegistration;
import com.flint.Weather.entity.Role;
import com.flint.Weather.entity.User;
import com.flint.Weather.repository.RoleRepository;
import com.flint.Weather.repository.UserRepository;
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
