package br.com.soundcraft;

import br.com.soundcraft.model.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SOUNDCRAFT - SISTEMA DE STREAMING ===\n");

        // 1. Criar Plano e Ouvinte
        PlanoAssinatura premium = new PlanoAssinatura("Premium", true, -1);
        Ouvinte ouvinte = new Ouvinte(1, "Nicolas Luã", "nicolas@email.com", premium);

        // 2. Criar Catálogo de Mídias
        Musica m1 = new Musica(10, "Bohemian Rhapsody", 354, "Rock", "Queen");
        Musica m2 = new Musica(11, "Hotel California", 390, "Rock", "Eagles");
        EpisodioPodcast p1 = new EpisodioPodcast(20, "POO na Prática", 1800, "Prof. Elmano");
        p1.salvarProgresso(120);

        List<Midia> catalogoGeral = new ArrayList<>();
        catalogoGeral.add(m1);
        catalogoGeral.add(m2);
        catalogoGeral.add(p1);

        // 3. Montar Playlist
        Playlist playlist = ouvinte.criarPlaylist(101, "Favoritas de 2026");
        playlist.adicionarMidia(m1);
        playlist.adicionarMidia(p1);

        // 4. Executar Fluxo de Reprodução Individual e Download
        System.out.println("Usuário: " + ouvinte.getNome() + " | Plano: " + ouvinte.getPlano().getTipo() + "\n");

        ouvinte.ouvirMidia(m1);
        ouvinte.ouvirMidia(m1); // Ouvindo a mesma música uma 2ª vez
        ouvinte.ouvirMidia(p1);

        if (m1 instanceof Baixavel && ouvinte.getPlano().isPermiteDownload()) {
            ((Baixavel) m1).baixar();
        }

        // 5. Consultar quantas vezes o usuário ouviu cada mídia
        System.out.println("\n--- HISTÓRICO INDIVIDUAL DO OUVINTE ---");
        System.out.println(ouvinte.getNome() + " ouviu '" + m1.getTitulo() + "' " + ouvinte.getQuantidadeReproducoes(m1) + " vez(es).");
        System.out.println(ouvinte.getNome() + " ouviu '" + p1.getTitulo() + "' " + ouvinte.getQuantidadeReproducoes(p1) + " vez(es).");
        System.out.println(ouvinte.getNome() + " ouviu '" + m2.getTitulo() + "' " + ouvinte.getQuantidadeReproducoes(m2) + " vez(es).");

        // 6. Testar Mecanismo de Recomendação
        System.out.println("\n--- RECOMENDAÇÕES PARA " + ouvinte.getNome().toUpperCase() + " ---");
        List<Midia> recomendadas = ouvinte.recomendarMidias(catalogoGeral);
        for (Midia rec : recomendadas) {
            System.out.println("⭐ Recomendado para você: " + rec.getTitulo());
        }
    }
}
