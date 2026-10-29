package br.com.soundcraft;

import br.com.soundcraft.model.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SOUNDCRAFT - SISTEMA DE STREAMING ===\n");

        PlanoAssinatura premium = new PlanoAssinatura("Premium", true, -1);
        Ouvinte ouvinte = new Ouvinte(1, "Nicolas Luã", "nicolas@email.com", premium);

        Musica musica = new Musica(10, "Bohemian Rhapsody", 354, "Rock", "Queen");
        EpisodioPodcast podcast = new EpisodioPodcast(20, "POO na Prática", 1800, "Prof. Elmano");
        podcast.salvarProgresso(120);

        Playlist playlist = ouvinte.criarPlaylist(101, "Favoritas de 2026");
        playlist.adicionarMidia(musica);
        playlist.adicionarMidia(podcast);

        System.out.println("Usuário: " + ouvinte.getNome() + " | Plano: " + ouvinte.getPlano().getTipo());
        System.out.println("Playlist: " + playlist.getNome() + "\n");

        for (Midia m : playlist.getItens()) {
            m.reproduzir();
            
            if (m instanceof Baixavel && ouvinte.getPlano().isPermiteDownload()) {
                ((Baixavel) m).baixar();
            }
            System.out.println("Total de reproduções: " + m.getReproducoes() + "\n");
        }
    }
}