package com.spotify.music.models;

public enum TipoArtista {
    SOLO("solo"),
    DUPLA("dupla"),
    BANDA("banda");

    private String tipoArtista;

    TipoArtista(String tipoArtista){
        this.tipoArtista = tipoArtista;
    }

    public static TipoArtista fromString(String txt){
        for (TipoArtista tipo:TipoArtista.values()){
            if (tipo.tipoArtista.equalsIgnoreCase(txt)){
                return tipo;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + txt);
    }
}