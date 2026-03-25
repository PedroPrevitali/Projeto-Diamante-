package br.com.fiap.LocadoraGames.services;
import br.com.fiap.LocadoraGames.Repository.GameRepository;
import br.com.fiap.LocadoraGames.models.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository repository;

    public List<Game> getAllgames(){
        return repository.findAll();
    }

    public Game addGame(Game game){
        return repository.save(game);
    }

    public Game getGameById(Long id){
        return findgameById(id);
    }

    public void deleteGame(Long id) {
        findgameById(id);
        repository.deleteById(id);
    }
    public Game updateGame(Long id, Game newGame) {
        findgameById(id);
        newGame.setId(id);
        return repository.save(newGame);
    }

    private Game findgameById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogo com id " + id + " não encontrado")
        );
    }
}

