package br.com.soundcraft.model;

public abstract class Midia {
    private int id;
    private String titulo;
    private int duracaoSegundos;
    private int reproducoes;

    public Midia(int id, String titulo, int duracaoSegundos) {
        this.id = id;
        this.titulo = titulo;
        this.duracaoSegundos = duracaoSegundos;
        this.reproducoes = 0;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public int getDuracaoSegundos() { return duracaoSegundos; }
    public int getReproducoes() { return reproducoes; }

    public void incrementarReproducoes() {
        this.reproducoes++;
    }

    public abstract void reproduzir();
}