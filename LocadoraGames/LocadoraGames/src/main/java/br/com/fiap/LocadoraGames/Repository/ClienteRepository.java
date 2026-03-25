package br.com.fiap.LocadoraGames.Repository;

import br.com.fiap.LocadoraGames.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
