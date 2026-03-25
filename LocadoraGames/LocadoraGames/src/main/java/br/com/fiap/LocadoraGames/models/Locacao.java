package br.com.fiap.LocadoraGames.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Locacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Game cliente;
    private Game game;
    private LocalDate rentalDate;
    private LocalDate returnDate;
}
