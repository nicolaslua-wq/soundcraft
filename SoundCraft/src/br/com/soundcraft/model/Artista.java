package br.com.soundcraft.model;

import java.util.ArrayList;
import java.util.List;

public class Artista extends Usuario {
    private String biografia;
    private List<Midia> obras;

    public Artista(int id, String nome, String email, String biografia) {
        super(id, nome, email);
        this.biografia = biografia;
        this.obras = new ArrayList<>();
    }

    public void publicarMidia(Midia m) {
        this.obras.add(m);
    }

    public String getBiografia() { return biografia; }
    public List<Midia> getObras() { return obras; }
}