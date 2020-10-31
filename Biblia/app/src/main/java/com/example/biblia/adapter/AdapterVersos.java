package com.example.biblia.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
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
    private  Activity activity;

    private SharedPreferences sharedPreferences;
    private int tamanhodefaul = 14;
    private int tamanhoconfig;


    public AdapterVersos(List<Versos> versosList, Context context, Activity activity){
       versosLista = versosList;
       this.context = context;
       this.activity = activity;
       sharedPreferences =  activity.getPreferences(Context.MODE_PRIVATE);
       tamanhoconfig  = sharedPreferences.getInt("TamanhoFonte",tamanhodefaul);
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

        versosHolder.txtVerso.setTextSize(tamanhoconfig);
        versosHolder.txtNroVerso.setTextSize(tamanhoconfig);

    }

    @Override
    public int getItemCount() {
        return versosLista.size();
    }
}
