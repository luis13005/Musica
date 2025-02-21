package com.spotify.music.models;

import jakarta.persistence.*;

@Entity
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long musicaId;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "artistaId")
    private Artista artista;
}
