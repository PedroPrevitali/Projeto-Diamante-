package br.com.fiap.LocadoraGames.services;

import br.com.fiap.LocadoraGames.Repository.LocacaoRepository;
import br.com.fiap.LocadoraGames.models.Game;
import br.com.fiap.LocadoraGames.models.Locacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class LocacaoService {

    @Autowired
    private LocacaoRepository repository;

    public List<Locacao> getAllLocacao(){
        return repository.findAll();
    }

    public Locacao addLocacao(Locacao locacao){
        return repository.save(locacao);
    }

    public Locacao getLocacaoById(Long id){
        return findLocacaoById(id);
    }

    public void deleteLocacao(Long id) {
        findLocacaoById(id);
        repository.deleteById(id);
    }

    public Locacao updateLocacao(Long id, Locacao newLocacao) {
        findLocacaoById(id);
        newLocacao.setId(id);
        return repository.save(newLocacao);
    }

    private Locacao findLocacaoById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Locação com id " + id + " não encontrado")
        );
    }
}
