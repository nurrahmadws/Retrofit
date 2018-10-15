package com.example.masabu.retrofit.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.masabu.retrofit.R;
import com.example.masabu.retrofit.activities.EditDataKabupatenActivity;
import com.example.masabu.retrofit.models.Kabupaten;

import java.util.List;

public class KabupatenAdapter extends RecyclerView.Adapter<KabupatenAdapter.KabupatenViewHolder> {

    private Context mctx;
    private List<Kabupaten> kabupatenList;
    private Button btnEdit, btnDelete;

    public KabupatenAdapter(Context mctx, List<Kabupaten> kabupatenList) {
        this.mctx = mctx;
        this.kabupatenList = kabupatenList;
    }

    @NonNull
    @Override
    public KabupatenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mctx).inflate(R.layout.recyclerview_kabupaten, parent, false);
        return new KabupatenViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KabupatenViewHolder holder, int position) {
        Kabupaten kabupaten = kabupatenList.get(position);

        holder.txtViewKabupaten.setText(kabupaten.getNm_kabupaten());
    }

    @Override
    public int getItemCount() {
        return kabupatenList.size();
    }

    class KabupatenViewHolder extends RecyclerView.ViewHolder{

        TextView txtViewKabupaten;

        public KabupatenViewHolder(View itemView) {
            super(itemView);

            txtViewKabupaten = itemView.findViewById(R.id.txtViewKabupaten);

            btnEdit = itemView.findViewById(R.id.btn_edit_data_kabupaten);
            btnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mctx, EditDataKabupatenActivity.class);
                    mctx.startActivity(intent);
                }
            });
        }
    }

}
