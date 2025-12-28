package com.isitcom.videogameapii;

import com.isitcom.videogameapii.Entity.Game;
import com.isitcom.videogameapii.Entity.Studio;
import com.isitcom.videogameapii.Repository.GameRepository;
import com.isitcom.videogameapii.Repository.StudioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VideoGameApiiApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideoGameApiiApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(GameRepository gameRepository, StudioRepository studioRepository) {
        return args -> {
            Studio nintendo = new Studio("Nintendo", 1889, "Japan");
            Studio valve = new Studio("Valve", 1996, "USA");
            studioRepository.save(nintendo);
            studioRepository.save(valve);

            Game g1 = new Game("The Legend of Zelda: Breath of the Wild", 2017, nintendo);
            Game g2 = new Game("Half-Life 2", 2004, valve);
            gameRepository.save(g1);
            gameRepository.save(g2);

            gameRepository.findAll().forEach(System.out::println);
        };

    }
}
