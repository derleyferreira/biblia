package com.example.biblia.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.biblia.R;

public class VersosViewHolder extends RecyclerView.ViewHolder {

    public TextView txtVerso;
    public TextView txtNroVerso;

    public VersosViewHolder(@NonNull View itemView) {
        super(itemView);

        txtVerso = itemView.findViewById(R.id.txt_Verso);
        txtNroVerso = itemView.findViewById(R.id.txt_nroVerso);
    }
}
