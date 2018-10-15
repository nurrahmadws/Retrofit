package com.example.masabu.retrofit.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.masabu.retrofit.R;
import com.example.masabu.retrofit.api.RetrofitClient;
import com.example.masabu.retrofit.models.DefaultResponse;
import com.example.masabu.retrofit.models.Kabupaten;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateKabupatenActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextKabupaten;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_kabupaten);

        editTextKabupaten = findViewById(R.id.editTextKabupaten);

        findViewById(R.id.buttonSaveKabupaten).setOnClickListener(this);
    }

    private void addKabupaten(){
        String nm_kabupaten = editTextKabupaten.getText().toString().trim();

        if (nm_kabupaten.isEmpty()){
            editTextKabupaten.setError("Kabupaten/Kota Required");
            editTextKabupaten.requestFocus();
            return;
        }

        Call<DefaultResponse> call = RetrofitClient.getInstance().getApi().createKabupaten(nm_kabupaten);
        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                if (response.code() == 201) {
                    DefaultResponse dr = response.body();
                    Intent intent = new Intent(CreateKabupatenActivity.this, com.example.masabu.retrofit.activities.KabupatenActivity.class);
                    startActivity(intent);
                }else if (response.code() == 422){
                    Toast.makeText(CreateKabupatenActivity.this, "Kabupaten/Kota Already Exist", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        addKabupaten();
    }
}
