package com.spotify.music.models;

import com.spotify.music.repository.RepositoryArtista;
import jakarta.persistence.*;

import java.util.List;
import java.util.Scanner;

@Entity
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long artistaId;
    private String nome;
    private TipoArtista tipoArtista;
    @OneToMany(mappedBy = "musicaId",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Musica> musicas;

    Artista(String nome,
            TipoArtista tipoArtista){
        this.nome = nome;
        this.tipoArtista = tipoArtista;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoArtista getTipoArtista() {
        return tipoArtista;
    }

    public void setTipoArtista(TipoArtista tipoArtista) {
        this.tipoArtista = tipoArtista;
    }

    @Override
    public String toString() {
        return "ID: "+this.artistaId+" Nome: "+this.nome+" Tipo: "+this.tipoArtista;
    }

    public static void cadastrarArtista(RepositoryArtista repositoryArtista){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do Artista/Banda: ");
        String nomeArtista = scanner.nextLine();

        System.out.println("Qual o Tipo do Artista: ");
        TipoArtista tipo = TipoArtista.fromString(scanner.nextLine());

        Artista artista = new Artista(nomeArtista,tipo);
        System.out.println(artista);
        repositoryArtista.save(artista);
    }
}
