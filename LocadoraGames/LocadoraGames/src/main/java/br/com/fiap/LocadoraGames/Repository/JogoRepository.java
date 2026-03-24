package br.com.fiap.LocadoraGames.Repository;

import br.com.fiap.LocadoraGames.models.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogoRepository extends JpaRepository<Jogo, Long>{
}
