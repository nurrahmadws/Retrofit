package com.example.masabu.retrofit.models;

public class Kabupaten {

    private int id_kabupaten;
    private String nm_kabupaten;

    public Kabupaten(int id_kabupaten, String nm_kabupaten) {
        this.id_kabupaten = id_kabupaten;
        this.nm_kabupaten = nm_kabupaten;
    }

    public int getId_kabupaten() {
        return id_kabupaten;
    }

    public String getNm_kabupaten() {
        return nm_kabupaten;
    }
}
