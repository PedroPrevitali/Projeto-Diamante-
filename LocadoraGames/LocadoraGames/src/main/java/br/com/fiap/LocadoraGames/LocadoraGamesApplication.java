package br.com.fiap.LocadoraGames;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@RestController

public class LocadoraGamesApplication {

    record  HelthStatus(String status, String message) {}

	public static void main(String[] args) {
		SpringApplication.run(LocadoraGamesApplication.class, args);
	}

    @GetMapping("/")
    public HealthStatus healthCheck() {
    return new HealthStatus("OK", "API em andamento");
}

}