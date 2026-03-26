package br.com.fiap.LocadoraGames.controllers;

import br.com.fiap.LocadoraGames.models.Cliente;

import br.com.fiap.LocadoraGames.services.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@Slf4j
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public List<Cliente> listAll(){
        return service.getAllClientes();
    }

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.addCliente(cliente));
    }

    @GetMapping("{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id){
        log.info("Obtendo dados do cliente {}", id);
        return ResponseEntity.ok(service.getClienteById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id){
        log.info("Deletando cliente com id {}", id );
        service.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente cliente){
        log.info("Atualizando o Cliente com id {} com os dados {}", id, cliente);
            return ResponseEntity.ok( service.updateCliente(id, cliente) );
    }
}
