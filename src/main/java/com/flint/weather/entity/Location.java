package com.flint.weather.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "location")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "country")
    private String country;
    @Column(name = "latitude")
    @JsonProperty("lat")
    private Double latitude;
    @Column(name = "longitude")
    @JsonProperty("lon")
    private Double longitude;
    @JoinColumn(name="user_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.MERGE)
    private User user;
}
