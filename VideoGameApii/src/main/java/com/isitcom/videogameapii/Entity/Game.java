package com.isitcom.videogameapii.Entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private int releaseYear;

    @ManyToOne
    private Studio studio;

    public Game(String title, int releaseYear) {
        this.title = title;
        this.releaseYear = releaseYear;
    }

    public Game(String title, int releaseYear, Studio studio) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.studio = studio;
    }
}
