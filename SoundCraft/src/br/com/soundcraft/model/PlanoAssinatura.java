package br.com.soundcraft.model;

public class PlanoAssinatura {
    private String tipo;
    private boolean permiteDownload;
    private int limitePulosPorHora;

    public PlanoAssinatura(String tipo, boolean permiteDownload, int limitePulosPorHora) {
        this.tipo = tipo;
        this.permiteDownload = permiteDownload;
        this.limitePulosPorHora = limitePulosPorHora;
    }

    public String getTipo() { return tipo; }
    public boolean isPermiteDownload() { return permiteDownload; }
}