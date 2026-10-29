package br.com.soundcraft.model;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private int id;
    private String nome;
    private List<Midia> itens;

    public Playlist(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.itens = new ArrayList<>();
    }

    public void adicionarMidia(Midia m) {
        this.itens.add(m);
    }

    public String getNome() { return nome; }
    public List<Midia> getItens() { return itens; }
}