package com.example.masabu.retrofit.models;

public class KabupatenUDResponse {
    private boolean error;
    private String message;
    private Kabupaten nm_kabupaten;

    public KabupatenUDResponse(boolean error, String message, Kabupaten nm_kabupaten) {
        this.error = error;
        this.message = message;
        this.nm_kabupaten = nm_kabupaten;
    }

    public boolean isError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public Kabupaten getNm_kabupaten() {
        return nm_kabupaten;
    }
}
