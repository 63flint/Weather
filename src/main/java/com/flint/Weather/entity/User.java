package com.flint.Weather.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable=false)
    private String name;
    @Column(nullable=false)
    private String password;
    @Column(nullable=false, unique=true)
    private String email;
    @OneToMany(mappedBy = "user")
    private List<Location> locations;
}
