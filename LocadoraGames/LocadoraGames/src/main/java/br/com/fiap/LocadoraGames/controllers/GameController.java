package br.com.fiap.LocadoraGames.controllers;

import br.com.fiap.LocadoraGames.models.Game;
import br.com.fiap.LocadoraGames.services.GameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
@Slf4j
public class GameController {

    @Autowired
    private GameService service;

    @GetMapping
    public List<Game> listAll(){
        return service.getAllgames();
    }

    @PostMapping
    public ResponseEntity<Game> createGame(@RequestBody Game game){ //binding
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.addGame(game));
    }

    @GetMapping("{id}")
    public ResponseEntity<Game> getJogoById(@PathVariable Long id){
        log.info("Obtendo dados do jogo {}", id);
        return ResponseEntity.ok(service.getGameById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteJogo(@PathVariable Long id){
        log.info("Deletando jogo com id {}", id );
        service.deleteGame(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Game> updateJogo(@PathVariable Long id, @RequestBody Game game){
        log.info("Atualizando o Jogo com id {} com os dados {}", id, game);
        return ResponseEntity.ok( service.updateGame(id, game) );
    }

}
