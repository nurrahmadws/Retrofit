package com.example.masabu.retrofit.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.masabu.retrofit.R;
import com.example.masabu.retrofit.api.RetrofitClient;
import com.example.masabu.retrofit.models.DefaultResponse;
import com.example.masabu.retrofit.models.LoginResponse;
import com.example.masabu.retrofit.models.User;
import com.example.masabu.retrofit.storage.SharedPrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditDataUserActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtUsername,edtLevel,edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data_user);

        edtUsername = findViewById(R.id.edtTextUsername);
        edtPassword = findViewById(R.id.edtTextNewPassword);
        edtLevel = findViewById(R.id.edtTextLevel);

        findViewById(R.id.btnSave).setOnClickListener(this);
        findViewById(R.id.btnChangePassword).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSave:

                break;
            case R.id.btnChangePassword:

                break;
        }
    }
}
