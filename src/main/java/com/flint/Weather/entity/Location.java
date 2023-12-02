package com.flint.Weather.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private User user;
}
