package com.spotify.music.repository;

import com.spotify.music.models.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryArtista extends JpaRepository<Artista,Long> {
}
