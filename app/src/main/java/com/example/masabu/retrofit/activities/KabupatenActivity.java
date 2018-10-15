package com.example.masabu.retrofit.activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.masabu.retrofit.R;
import com.example.masabu.retrofit.adapters.KabupatenAdapter;
import com.example.masabu.retrofit.api.RetrofitClient;
import com.example.masabu.retrofit.models.Kabupaten;
import com.example.masabu.retrofit.models.KabupatenResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KabupatenActivity extends AppCompatActivity {

    private RecyclerView rv;
    private KabupatenAdapter kabupatenAdapter;
    private List<Kabupaten> kabupatenList;
    private FloatingActionButton fab;
    public static KabupatenActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kabupaten);

        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(KabupatenActivity.this));

        ma = this;
        refresh();

        fab = findViewById(R.id.fabb);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KabupatenActivity.this, CreateKabupatenActivity.class);
                startActivity(intent);
            }
        });
    }

    public void refresh(){
        Call<KabupatenResponse> call = RetrofitClient.getInstance().getApi().getKabupaten();
        call.enqueue(new Callback<KabupatenResponse>() {
            @Override
            public void onResponse(Call<KabupatenResponse> call, Response<KabupatenResponse> response) {
                kabupatenList = response.body().getAllData();
                kabupatenAdapter = new KabupatenAdapter(KabupatenActivity.this, kabupatenList);
                rv.setAdapter(kabupatenAdapter);
            }

            @Override
            public void onFailure(Call<KabupatenResponse> call, Throwable t) {

            }
        });
    }
}
