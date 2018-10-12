package com.example.masabu.retrofit.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.masabu.retrofit.R;
import com.example.masabu.retrofit.activities.DataUserActivity;
import com.example.masabu.retrofit.activities.EditDataUserActivity;
import com.example.masabu.retrofit.api.RetrofitClient;
import com.example.masabu.retrofit.models.DefaultResponse;
import com.example.masabu.retrofit.models.User;
import com.example.masabu.retrofit.storage.SharedPrefManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder> {

    private Context mCtx;
    private List<User> userList;
    private Button button1, button2;

    public UsersAdapter(Context mCtx, List<User> userList) {
        this.mCtx = mCtx;
        this.userList = userList;
    }

    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_users, parent, false);
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {
        User user = userList.get(position);

        holder.txtViewUsername.setText(user.getUsername());
        holder.txtViewLevel.setText(user.getLevel());
    }


    @Override
    public int getItemCount() {
        return userList.size();
    }

    class UsersViewHolder extends RecyclerView.ViewHolder{

        TextView txtViewUsername, txtViewLevel;

        UsersViewHolder(View itemView) {
            super(itemView);

            txtViewUsername = itemView.findViewById(R.id.txtViewUsername);
            txtViewLevel = itemView.findViewById(R.id.txtViewLevel);

            button1 = itemView.findViewById(R.id.btn_edit_data_user);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mCtx, EditDataUserActivity.class);
                    mCtx.startActivity(intent);
                }
            });

            button2 = itemView.findViewById(R.id.btn_delete_data_user);
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(mCtx);
                    builder.setTitle("Are You Sure Delete This User?");
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            User user = SharedPrefManager.getInstance(mCtx).getUser();
                            Call<DefaultResponse> call = RetrofitClient.getInstance().getApi().deleteUser(user.getId_user());

                            call.enqueue(new Callback<DefaultResponse>() {
                                @Override
                                public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {

                                    if (response.isSuccessful()){
                                        Intent intent = new Intent(mCtx, DataUserActivity.class);
                                        mCtx.startActivity(intent);
                                    }
                                }

                                @Override
                                public void onFailure(Call<DefaultResponse> call, Throwable t) {

                                }
                            });
                        }
                    });
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            });
        }
    }

}
