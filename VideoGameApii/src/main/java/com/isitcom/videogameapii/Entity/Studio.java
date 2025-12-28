package com.isitcom.videogameapii.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Studio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer foundedYear;
    private String country;

    @OneToMany(mappedBy = "studio", fetch = FetchType.EAGER)
    @JsonIgnore
    List<Game> games = new ArrayList<>();

    public Studio(String name) {
        this.name = name;
    }

    public Studio(String name, Integer foundedYear, String country) {
        this.name = name;
        this.foundedYear = foundedYear;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Studio{" + "id=" + id + '\'' + '}';
    }
}
