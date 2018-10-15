package com.example.masabu.retrofit.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.masabu.retrofit.R;
import com.example.masabu.retrofit.api.RetrofitClient;
import com.example.masabu.retrofit.models.DefaultResponse;
import com.example.masabu.retrofit.models.Kabupaten;
import com.example.masabu.retrofit.models.KabupatenUDResponse;
import com.example.masabu.retrofit.storage.SharedPrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditDataKabupatenActivity extends AppCompatActivity {

    EditText edttTextKabupaten, edtTextid;
    Button buttonUpdateKabupaten;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data_kabupaten);

        edtTextid = findViewById(R.id.edtTextid);
        edttTextKabupaten = findViewById(R.id.edttTextKabupaten);

        Intent intent = getIntent();
        edtTextid.setText(intent.getStringExtra("Id"));
        edtTextid.setTag(edtTextid.getKeyListener());
        edtTextid.setKeyListener(null);
        edttTextKabupaten.setText(intent.getStringExtra("Kabupaten"));


        buttonUpdateKabupaten = findViewById(R.id.buttonUpdateKabupaten);
        buttonUpdateKabupaten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nm_kabupaten = edttTextKabupaten.getText().toString();

                if (nm_kabupaten.isEmpty()){
                    edttTextKabupaten.setError("Kabupaten/Kota Required");
                    edttTextKabupaten.requestFocus();
                    return;
                }

               Call<KabupatenUDResponse> call = RetrofitClient.getInstance().getApi().updateKabupaten(
                       edtTextid.getText().toString(),
                        nm_kabupaten
               );

                call.enqueue(new Callback<KabupatenUDResponse>() {
                    @Override
                    public void onResponse(Call<KabupatenUDResponse> call, Response<KabupatenUDResponse> response) {
                        if (!response.body().isError()){
                            KabupatenActivity.ma.refresh();
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<KabupatenUDResponse> call, Throwable t) {

                    }
                });
            }
        });
    }
}
