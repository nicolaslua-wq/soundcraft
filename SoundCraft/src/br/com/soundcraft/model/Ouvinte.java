package br.com.soundcraft.model;

import java.util.ArrayList;
import java.util.List;

public class Ouvinte extends Usuario {
    private PlanoAssinatura plano;
    private List<Playlist> playlists;

    public Ouvinte(int id, String nome, String email, PlanoAssinatura plano) {
        super(id, nome, email);
        this.plano = plano;
        this.playlists = new ArrayList<>();
    }

    public Playlist criarPlaylist(int idPlaylist, String nome) {
        Playlist p = new Playlist(idPlaylist, nome);
        this.playlists.add(p);
        return p;
    }

    public PlanoAssinatura getPlano() { return plano; }
    public List<Playlist> getPlaylists() { return playlists; }
}