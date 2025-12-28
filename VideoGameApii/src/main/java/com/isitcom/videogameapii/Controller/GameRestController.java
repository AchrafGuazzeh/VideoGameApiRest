package com.isitcom.videogameapii.Controller;

import com.isitcom.videogameapii.DTO.GameDTO;
import com.isitcom.videogameapii.Entity.Game;
import com.isitcom.videogameapii.Entity.Studio;
import com.isitcom.videogameapii.Repository.GameRepository;
import com.isitcom.videogameapii.Repository.StudioRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.BeanUtils;

import java.util.List;

@RestController
@AllArgsConstructor
public class GameRestController {

    private final GameRepository gr;
    private final StudioRepository sr;

    @GetMapping("/ListeGames")
    public ResponseEntity<List<Game>> listeGames() {
        List<Game> games = gr.findAll();
        return ResponseEntity.ok(games);
    }

    @GetMapping("/game/{id}")
    public ResponseEntity<GameDTO> getGameById(@PathVariable Long id) {
        Game game = gr.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found"));
        GameDTO dto = new GameDTO();
        BeanUtils.copyProperties(game, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/game/{id}")
    public ResponseEntity<Void> suppression(@PathVariable Long id) {
        if (!gr.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        gr.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/save", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Game> ajouter(@RequestBody Game g) {

        if (g.getStudio() != null && g.getStudio().getId() != null) {
            Studio s = sr.findById(g.getStudio().getId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Studio not found with id " + g.getStudio().getId()));
            g.setStudio(s);
        } else {
            g.setStudio(null);
        }
        Game saved = gr.save(g);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Game> modifier(@RequestBody Game g) {
        if (g.getId() == null || !gr.existsById(g.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Game id missing or does not exist");
        }
        if (g.getStudio() != null && g.getStudio().getId() != null) {
            Studio s = sr.findById(g.getStudio().getId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Studio not found with id " + g.getStudio().getId()));
            g.setStudio(s);
        } else {
            g.setStudio(null);
        }
        Game updated = gr.save(g);
        return ResponseEntity.ok(updated);
    }
}