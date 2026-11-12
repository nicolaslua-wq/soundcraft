package br.com.soundcraft.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ouvinte extends Usuario {
    private PlanoAssinatura plano;
    private List<Playlist> playlists;
    private Map<Midia, Integer> historicoReproducoes;

    public Ouvinte(int id, String nome, String email, PlanoAssinatura plano) {
        super(id, nome, email);
        this.plano = plano;
        this.playlists = new ArrayList<>();
        this.historicoReproducoes = new HashMap<>();
    }

    public Playlist criarPlaylist(int idPlaylist, String nome) {
        Playlist p = new Playlist(idPlaylist, nome);
        this.playlists.add(p);
        return p;
    }

    // Registra a reprodução tanto na mídia quanto no histórico individual do ouvinte
    public void ouvirMidia(Midia m) {
        m.reproduzir();
        int vezesOuvida = historicoReproducoes.getOrDefault(m, 0);
        historicoReproducoes.put(m, vezesOuvida + 1);
    }

    // Retorna quantas vezes ESTE ouvinte especificamente ouviu a mídia
    public int getQuantidadeReproducoes(Midia m) {
        return historicoReproducoes.getOrDefault(m, 0);
    }

    // Mecanismo simples de recomendação: sugere mídias do catálogo que o ouvinte ainda não ouviu
    public List<Midia> recomendarMidias(List<Midia> catalogoGeral) {
        List<Midia> recomendacoes = new ArrayList<>();
        
        for (Midia m : catalogoGeral) {
            if (!historicoReproducoes.containsKey(m)) {
                recomendacoes.add(m);
            }
        }
        return recomendacoes;
    }

    public PlanoAssinatura getPlano() { return plano; }
    public List<Playlist> getPlaylists() { return playlists; }
    public Map<Midia, Integer> getHistoricoReproducoes() { return historicoReproducoes; }
}
