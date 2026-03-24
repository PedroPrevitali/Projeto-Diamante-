package br.com.fiap.LocadoraGames.services;

import
import br.com.fiap.LocadoraGames.models.Jogo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocadoraService {
    @Autowired
    private LocadoraRepository repository;

    public List<Jogo> getAllJogos(){
        return repository.findAll();
    }

    public Jogo addJogo(Jogo jogo){
        return repository.save(jogo);
    }

    public Jogo getJogoById(Long id){
        return findJogoById(id);
    }

    public void deleteMovie(Long id) {
        findJogoById(id);
        repository.deleteById(id);
    }
    public Jogo updateMovie(Long id, Jogo newMovie) {
        findJogoById(id);
        newJogo.setId(id);
        return repository.save(newJogo);
    }

    private Jogo findJogoById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogo com id " + id + " não encontrado")
        );
    }
}
}
