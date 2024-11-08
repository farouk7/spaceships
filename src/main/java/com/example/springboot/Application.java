package com.example.springboot;

import com.example.springboot.model.SpaceShip;
import com.example.springboot.repository.SpaceShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
	@Autowired
	private SpaceShipRepository spaceShipRepository; // Inyecta el repositorio de SpaceShip


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Bean
	public CommandLineRunner run() {
		return args -> {
			// Crear una nueva instancia de SpaceShip
			SpaceShip spaceShip = new SpaceShip();
			spaceShip.setName("USS Enterprise");
			spaceShip.setSeries("Star Trek");
			spaceShip.setOrigin("Earth");

			// Guardar el SpaceShip en la base de datos
			spaceShipRepository.save(spaceShip);

			// Puedes añadir más inserciones si lo deseas
			spaceShipRepository.save(new SpaceShip("Millennium Falcon", "Star Wars", "Corellia"));
			spaceShipRepository.save(new SpaceShip("Serenity", "Firefly", "Unknown"));
		};
	}
}
