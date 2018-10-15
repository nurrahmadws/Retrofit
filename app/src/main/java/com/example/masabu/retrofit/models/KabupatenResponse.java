package com.example.masabu.retrofit.models;

import java.util.List;

public class KabupatenResponse {

    private boolean error;
    private List<Kabupaten> allData;

    public KabupatenResponse(boolean error, List<Kabupaten> allData) {
        this.error = error;
        this.allData = allData;
    }

    public boolean isError() {
        return error;
    }

    public List<Kabupaten> getAllData() {
        return allData;
    }
}
