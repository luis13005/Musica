package com.spotify.music.principal;

import com.spotify.music.models.Artista;
import com.spotify.music.models.Musica;
import com.spotify.music.repository.RepositoryArtista;
import com.spotify.music.repository.RepositoryMusica;
import com.spotify.music.service.ConsultaChatGPT;

import java.util.List;
import java.util.Optional;
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
            scanner.nextLine();
            switch (opcao){
                case 1:
                    cadastrarArtista(repositoryArtista);
                    break;
                case 2:
                    cadastrarMusica(repositoryMusica,repositoryArtista);
                    break;
                case 3:
                    listaTodasMusicas(repositoryMusica);
                    break;
                case 4:
                    listaMusicasPorArtistas(repositoryArtista);
                    break;
                case 5:
                    sobreArtista();
                    break;
                case 9:
                    System.out.println("Tchau!!");
                    break;
                default:
                    System.out.println("Digite uma Opção válida.");
            }
        }
    }

    private static void sobreArtista() {
        System.out.println("Qual artista vocçê deseja saber sobre: ");
        String artistaNome = scanner.nextLine();

        String dadosArtista = ConsultaChatGPT.Consultar(artistaNome);

        System.out.println(dadosArtista);
    }

    private static void listaMusicasPorArtistas(RepositoryArtista repositoryArtista) {
        System.out.println("Digite o Artista: ");
        var artistaNome = scanner.nextLine();
        if(artistaNome.length() > 0){
            Artista artista = repositoryArtista.consultaArtistas(artistaNome);

            Optional<Musica> musicaOptional = repositoryArtista.consultaMusicasPorArtista(artista);
            if (musicaOptional.isPresent()){
                musicaOptional.stream().forEach(System.out::println);
            }
        }
    }

    private static void listaTodasMusicas(RepositoryMusica repositoryMusica) {
        List<Musica> musicaList = repositoryMusica.consultaTodasMusicas();
        musicaList.stream().forEach(System.out::println);
    }
}
