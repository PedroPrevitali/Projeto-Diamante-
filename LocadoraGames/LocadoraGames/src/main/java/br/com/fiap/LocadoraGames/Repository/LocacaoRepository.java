package br.com.fiap.LocadoraGames.Repository;

import br.com.fiap.LocadoraGames.models.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocacaoRepository extends JpaRepository<Locacao, Long> {
}
