package com.spotify.music;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.spotify.music.principal.Principal.Exibe;

@SpringBootApplication
public class MusicApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MusicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Exibe();
	}
}
