package br.com.fiap.LocadoraGames.services;

import br.com.fiap.LocadoraGames.Repository.ClienteRepository;
import br.com.fiap.LocadoraGames.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> getAllClientes() {
        return repository.findAll();
    }

    public Cliente addCliente(Cliente cliente) {
        return repository.save(cliente);
    }

    public Cliente getClienteById(Long id){
        return findClienteById(id);
    }

    public void deleteCliente(Long id) {
        findClienteById(id);
        repository.deleteById(id);
    }
    public Cliente updateCliente(Long id, Cliente newCliente) {
        findClienteById(id);
        newCliente.setId(id);
        return repository.save(newCliente);
    }

    private Cliente findClienteById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente com id " + id + " não encontrado")
        );
    }
}