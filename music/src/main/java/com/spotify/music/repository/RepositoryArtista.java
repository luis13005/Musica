package com.spotify.music.repository;

import com.spotify.music.models.Artista;
import com.spotify.music.models.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RepositoryArtista extends JpaRepository<Artista,Long> {
    @Query("Select a From Artista a where a.nome ilike %:artistaNome%")
    Artista consultaArtistas(String artistaNome);
    @Query("Select m From Artista a Join Musica m On a = m.artista where a = :artista")
    Optional<Musica> consultaMusicasPorArtista(Artista artista);
}
