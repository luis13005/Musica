package com.spotify.music.principal;

import com.spotify.music.repository.RepositoryArtista;
import com.spotify.music.repository.RepositoryMusica;

import java.util.Scanner;

import static com.spotify.music.models.Artista.cadastrarArtista;
import static com.spotify.music.models.Musica.cadastrarMusica;

public class Principal {
    private static Scanner scanner = new Scanner(System.in);

    public static void Exibe(RepositoryArtista repositoryArtista,
                             RepositoryMusica repositoryMusica){

        var opcao = 0;

        while (opcao != 9){
            System.out.println("""
                    1- Cadastrar artistas
                    
                    2- Cadastrar músicas
                    
                    3- Listar músicas
                    
                    4- Buscar músicas por artistas
                    
                    5- Pesquisar dados sobre um artista
                    
                    9- Sair
                    """);
            opcao = scanner.nextInt();
            switch (opcao){
                case 1:
                    cadastrarArtista(repositoryArtista);
                    break;
                case 2:
                    cadastrarMusica(repositoryMusica,repositoryArtista);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 9:
                    System.out.println("Tchau!!");
                    break;
                default:
                    System.out.println("Digite uma Opção válida.");
            }
        }
    }
}
