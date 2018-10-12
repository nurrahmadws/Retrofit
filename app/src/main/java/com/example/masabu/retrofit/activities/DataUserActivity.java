package com.example.masabu.retrofit.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import com.example.masabu.retrofit.R;
import com.example.masabu.retrofit.adapters.UsersAdapter;
import com.example.masabu.retrofit.api.RetrofitClient;
import com.example.masabu.retrofit.models.DefaultResponse;
import com.example.masabu.retrofit.models.User;
import com.example.masabu.retrofit.models.UsersResponse;
import com.example.masabu.retrofit.storage.SharedPrefManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataUserActivity extends AppCompatActivity{

    Button btn_edit_data_user, btn_delete_data_user;

    private RecyclerView recyclerVieww;
    private UsersAdapter adapter;
    private List<User> userList;
    private FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_user);

        recyclerVieww = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerVieww.setLayoutManager(new LinearLayoutManager(DataUserActivity.this));

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataUserActivity.this, CreateUserActivity.class);
                startActivity(intent);
            }
        });

        Call<UsersResponse> call = RetrofitClient.getInstance().getApi().getUsers();

        call.enqueue(new Callback<UsersResponse>() {
            @Override
            public void onResponse(Call<UsersResponse> call, Response<UsersResponse> response) {
                userList = response.body().getUsers();
                adapter = new UsersAdapter(DataUserActivity.this, userList);
                recyclerVieww.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<UsersResponse> call, Throwable t) {

            }
        });

    }
}