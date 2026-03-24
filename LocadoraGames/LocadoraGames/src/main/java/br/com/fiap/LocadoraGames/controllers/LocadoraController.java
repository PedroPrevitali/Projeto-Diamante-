package br.com.fiap.LocadoraGames.controllers;

import br.com.fiap.LocadoraGames.models.Jogo;
import br.com.fiap.LocadoraGames.services.LocadoraService;
import org.springframework.beans.factory.annotation.Autowired;

public class LocadoraController {

    @Autowired
    private LocadoraService service;

    @GetMapping
    public List<Jogo> listAll(){
        return service.getAllJogos();
    }

    @PostMapping
    public ResponseEntity<Jogo> createJogo(@RequestBody Jogo jogo){ //binding
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.addJogo(jogo));
    }

    @GetMapping("{id}")
    public ResponseEntity<Jogo> getJogoById(@PathVariable Long id){
        log.info("Obtendo dados do jogo {}", id);
        return ResponseEntity.ok(service.getJogoById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteJogo(@PathVariable Long id){
        log.info("Deletando jogo com id {}", id );
        service.deleteJogo(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Jogo> updateJogo(@PathVariable Long id, @RequestBody Jogo jogo){
        log.info("Atualizando o Jogo com id {} com os dados {}", id, jogo);
        return ResponseEntity.ok( service.updateJogo(id, jogo) );
    }

}
}