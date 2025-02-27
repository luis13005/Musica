package com.spotify.music;

import com.spotify.music.repository.RepositoryArtista;
import com.spotify.music.repository.RepositoryMusica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.spotify.music.principal.Principal.Exibe;

@SpringBootApplication
public class MusicApplication implements CommandLineRunner {

	@Autowired
	private RepositoryArtista repositoryArtista;
	@Autowired
	private RepositoryMusica repositoryMusica;


	public static void main(String[] args) {
		SpringApplication.run(MusicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Exibe(repositoryArtista,repositoryMusica);
	}
}
