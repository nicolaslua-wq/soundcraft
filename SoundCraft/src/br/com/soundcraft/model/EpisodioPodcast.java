package br.com.soundcraft.model;

public class EpisodioPodcast extends Midia implements Baixavel {
    private String nomeHost;
    private int tempoParadaSegundos;

    public EpisodioPodcast(int id, String titulo, int duracaoSegundos, String nomeHost) {
        super(id, titulo, duracaoSegundos);
        this.nomeHost = nomeHost;
        this.tempoParadaSegundos = 0;
    }

    public void salvarProgresso(int segundos) {
        this.tempoParadaSegundos = segundos;
    }

    @Override
    public void reproduzir() {
        incrementarReproducoes();
        System.out.println("🎙️ Retomando podcast: " + getTitulo() + " (Host: " + nomeHost + ") no segundo " + tempoParadaSegundos);
    }

    @Override
    public void baixar() {
        System.out.println("⬇️ Baixando episódio de podcast: " + getTitulo() + "...");
    }
}