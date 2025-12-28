package com.isitcom.videogameapii.Repository;


import com.isitcom.videogameapii.Entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long>{

}