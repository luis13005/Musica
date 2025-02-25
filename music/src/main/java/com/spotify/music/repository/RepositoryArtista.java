package com.spotify.music.repository;

import com.spotify.music.models.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RepositoryArtista extends JpaRepository<Artista,Long> {
    @Query("Select a From Artista a where a.nome ilike %:artistaNome%")
    Artista consultaArtistas(String artistaNome);
}
