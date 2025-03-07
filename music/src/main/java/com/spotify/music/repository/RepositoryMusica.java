package com.spotify.music.repository;

import com.spotify.music.models.Artista;
import com.spotify.music.models.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositoryMusica extends JpaRepository<Musica, Long> {
    @Query("Select m From Musica m")
    List<Musica> consultaTodasMusicas();
}
