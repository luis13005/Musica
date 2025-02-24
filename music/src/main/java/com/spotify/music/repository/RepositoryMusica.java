package com.spotify.music.repository;

import com.spotify.music.models.Artista;
import com.spotify.music.models.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RepositoryMusica extends JpaRepository<Musica, Long> {
    @Query("Select a From Artista a where a.nome ILIKE :artistaNome")
    Artista consultaArtistas(String artistaNome);
}
