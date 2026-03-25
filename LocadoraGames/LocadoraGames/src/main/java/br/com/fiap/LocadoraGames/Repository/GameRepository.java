package br.com.fiap.LocadoraGames.Repository;

import br.com.fiap.LocadoraGames.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long>{
}
