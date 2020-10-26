package com.example.biblia.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.biblia.R;
import com.example.biblia.entity.Livros;
import com.example.biblia.entity.Versos;

import java.util.List;

public class AdapterVersos extends RecyclerView.Adapter {

    private  List<Versos> versosLista;
    private  Context context;

    public AdapterVersos(List<Versos> versosList, Context context){
       versosLista = versosList;
       this.context = context;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.activity_versos_holder,parent,false);

        VersosViewHolder verso = new VersosViewHolder(view);

        return  verso;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        VersosViewHolder versosHolder = (VersosViewHolder) holder;

        Versos verso = versosLista.get(position);
        versosHolder.txtVerso.setText(verso.getVerso());
        versosHolder.txtNroVerso.setText(String.valueOf(verso.getNumeroVerso()));

    }

    @Override
    public int getItemCount() {
        return versosLista.size();
    }
}
