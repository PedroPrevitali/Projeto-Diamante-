package br.com.fiap.LocadoraGames.controllers;

import br.com.fiap.LocadoraGames.models.Game;
import br.com.fiap.LocadoraGames.models.Locacao;
import br.com.fiap.LocadoraGames.services.GameService;
import br.com.fiap.LocadoraGames.services.LocacaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locacao")
@Slf4j
public class LocacaoController {

    @Autowired
    private LocacaoService service;

    @GetMapping
    public List<Locacao> listAll(){
        return service.getAllLocacao();
    }

    @PostMapping
    public ResponseEntity<Locacao> createLocacao(@RequestBody Locacao locacao){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.addLocacao(locacao));
    }

    @GetMapping("{id}")
    public ResponseEntity<Locacao> getLocacaoById(@PathVariable Long id){
        log.info("Obtendo dados da locação {}", id);
        return ResponseEntity.ok(service.getLocacaoById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteLocacao(@PathVariable Long id){
        log.info("Deletando locação com id {}", id );
        service.deleteLocacao(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Locacao> updateLocacao(@PathVariable Long id, @RequestBody Locacao locacao){
        log.info("Atualizando o Jogo com id {} com os dados {}", id, locacao);
        return ResponseEntity.ok( service.updateLocacao(id, locacao) );
    }
}
