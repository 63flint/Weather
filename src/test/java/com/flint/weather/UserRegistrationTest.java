package com.flint.weather;

import com.flint.weather.entity.Location;
import com.flint.weather.entity.Role;
import com.flint.weather.entity.User;
import com.flint.weather.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class UserRegistrationTest {
    private static final String IMAGE_VERSION = "postgres:16-alpine";
    @Autowired
    private UserRepository userRepository;
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(IMAGE_VERSION)
            .withDatabaseName("test-db")
            .withUsername("test")
            .withPassword("test");

    @BeforeAll
    static void beforeAll() {
        postgres.start();
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
    }

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @BeforeEach
    void setUp() {
//        DBConnectionProvider connectionProvider = new DBConnectionProvider(
//                postgres.getJdbcUrl(),
//                postgres.getUsername(),
//                postgres.getPassword()
//        );
//        customerService = new CustomerService(connectionProvider);
    }

    @Test
    void shouldGetCustomers() {
//        customerService.createCustomer(new Customer(1L, "George"));
//        customerService.createCustomer(new Customer(2L, "John"));
//
//        List<Customer> customers = customerService.getAllCustomers();
//        assertEquals(2, customers.size());
    }

    @Test
    @Transactional
    public void createUser(){
        userRepository.save(new User(1L, "Sam Stone", "123", "sam@mail.com", new ArrayList<Role>(), new ArrayList<Location>()));
        Optional<User> user = userRepository.findByEmail("sam@mail.com");
        if(user.isPresent()){
            System.out.println(user.get().getName());
            assertThat(user.get().getName()).isEqualTo("Sam Stone");
        }

    }
}
