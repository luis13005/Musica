package com.spotify.music.models;

import com.spotify.music.repository.RepositoryMusica;
import jakarta.persistence.*;

import java.util.Scanner;

@Entity
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long musicaId;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "artistaId")
    private Artista artista;

    private static Scanner scanner = new Scanner(System.in);

    public Musica(String nome, Artista artista) {
        this.nome = nome;
        this.artista = artista;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }


    public static void cadastrarMusica(RepositoryMusica repositoryMusica){
        System.out.println("Digite o nome da Musica: ");
        var musicaNome = scanner.nextLine();

        System.out.println("Digite o nome do Artista/Banda ou Dupla: ");
        var artistaNome = scanner.nextLine();

        Artista artista = repositoryMusica.consultaArtistas(artistaNome);

        try {
            Musica musica = new Musica(musicaNome,artista);
            repositoryMusica.save(musica);
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }
}
