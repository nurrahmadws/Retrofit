package com.example.masabu.retrofit.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.masabu.retrofit.R;
import com.example.masabu.retrofit.api.RetrofitClient;
import com.example.masabu.retrofit.models.DefaultResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateUserActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextUsername, editTextPassword, editTextLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextLevel    = findViewById(R.id.editTextLevel);

        findViewById(R.id.btnAddUser).setOnClickListener(this);
    }

    private void adduser(){
        String username = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String level    = editTextLevel.getText().toString().trim();

        if (username.isEmpty()){
            editTextUsername.setError("Username is Required");
            editTextUsername.requestFocus();
            return;
        }

        if (password.isEmpty()){
            editTextPassword.setError("Password Required");
            editTextPassword.requestFocus();
            return;
        }

        if (password.length() < 6){
            editTextPassword.setError("Password must be Longer than 6 character");
            editTextPassword.requestFocus();
            return;
        }

        if (level.isEmpty()){
            editTextLevel.setError("Level Required");
            editTextLevel.requestFocus();
            return;
        }

        if (!level.matches("Admin") && !level.matches("Mahasiswa")){
            editTextLevel.setError("Level Must be Admin or Mahasiswa");
            editTextLevel.requestFocus();
            return;
        }

        Call<DefaultResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .createUser(username, password, level);

        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                if (response.code() == 201) {
                    DefaultResponse dr = response.body();
                    Toast.makeText(CreateUserActivity.this, dr.getMsg(), Toast.LENGTH_LONG).show();
                }else if (response.code() == 422){
                    Toast.makeText(CreateUserActivity.this, "User Already Exist", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        adduser();
    }
}
