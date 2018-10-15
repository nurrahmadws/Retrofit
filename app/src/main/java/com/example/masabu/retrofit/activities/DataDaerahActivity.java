package com.example.masabu.retrofit.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.masabu.retrofit.R;

public class DataDaerahActivity extends AppCompatActivity implements View.OnClickListener{

     Button btn_data_kabupaten, btn_data_kecamatan, btn_data_kelurahan, btn_data_latlng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_daerah);

        btn_data_kabupaten = (Button) findViewById(R.id.btn_data_kabupaten);
        btn_data_kecamatan = (Button) findViewById(R.id.btn_data_kecamatan);
        btn_data_kelurahan = (Button) findViewById(R.id.btn_data_kelurahan);
        btn_data_latlng = (Button) findViewById(R.id.btn_data_latlng);

        btn_data_kabupaten.setOnClickListener(this);
        btn_data_kecamatan.setOnClickListener(this);
        btn_data_kelurahan.setOnClickListener(this);
        btn_data_latlng.setOnClickListener(this);

    }

    private void goKabupaten(){
        Intent intent = new Intent(DataDaerahActivity.this, KabupatenActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_data_kabupaten:
                goKabupaten();
                break;
            case R.id.btn_data_kecamatan:

                break;
            case R.id.btn_data_kelurahan:

                break;
            case R.id.btn_data_latlng:

                break;
        }
    }
}
