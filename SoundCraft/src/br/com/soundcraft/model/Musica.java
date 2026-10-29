package br.com.soundcraft.model;

public class Musica extends Midia implements Baixavel {
    private String genero;
    private String artista;

    public Musica(int id, String titulo, int duracaoSegundos, String genero, String artista) {
        super(id, titulo, duracaoSegundos);
        this.genero = genero;
        this.artista = artista;
    }

    public String getGenero() { return genero; }
    public String getArtista() { return artista; }

    @Override
    public void reproduzir() {
        incrementarReproducoes();
        System.out.println("▶ Tocando música: " + getTitulo() + " - " + artista + " [00:00]");
    }

    @Override
    public void baixar() {
        System.out.println("⬇️ Baixando faixa em MP3: " + getTitulo() + "...");
    }
}