package br.com.fiap.LocadoraGames.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class Locacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Cliente cliente;

    private Game game;

    private String name;

    private LocalDate rentalDate;

    private LocalDate returnDate;
}
