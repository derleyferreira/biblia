package com.example.biblia.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.biblia.R;
import com.example.biblia.adapter.AdapterVersos;
import com.example.biblia.data.LivroDAO;
import com.example.biblia.data.VersosDAO;
import com.example.biblia.entity.Livros;
import com.example.biblia.entity.Versos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private LivroDAO livroDAO;
    private VersosDAO versosDAO;
    private ArrayList<Versos> versos;
    private RecyclerView listaVersos;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        listaVersos = root.findViewById(R.id.listaVersos);

        livroDAO = new LivroDAO(getContext());
        versosDAO = new VersosDAO(getContext());
        ArrayList<Livros> arrayList = (ArrayList<Livros>) livroDAO.retornaLivros();

        versos = (ArrayList<Versos>) versosDAO.retornaVersos(arrayList.get(0).getPK());

        ArrayList<String> lista = new ArrayList<>();

        ArrayList<String> capitulos = new ArrayList<>();
        ArrayList<String> textoVersos = new ArrayList<>();

        for(int i = 0; i<arrayList.size();i++)
        {
            lista.add(arrayList.get(i).getNome());
        }

        for (int i = 0; i < versos.size(); i++){

            capitulos.add(String.valueOf(versos.get(i).getCapitulo()));

            textoVersos.add(versos.get(i).getVerso());
        }

        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_dropdown_item,lista);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Set set = new HashSet(capitulos);
        capitulos.clear();
        capitulos.addAll(set);

        ArrayAdapter adapterCapitulos = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_dropdown_item,capitulos);
        adapterCapitulos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spnLivro = root.findViewById(R.id.spn_Livro);
        spnLivro.setAdapter(adapter);

        Spinner spnCapitulos = root.findViewById(R.id.spinner2);
        spnCapitulos.setAdapter(adapterCapitulos);
        spnCapitulos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                versos = (ArrayList<Versos>) versosDAO.retornaVersos(spnLivro.getSelectedItemPosition()+1,position+1);
                textoVersos.clear();

                for (int i = 0; i < versos.size(); i++){

                    textoVersos.add(versos.get(i).getVerso());
                }
                listaVersos.setAdapter(new AdapterVersos(versos,getContext(),getActivity()));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Spinner spinner = root.findViewById(R.id.spn_Livro);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Livros livro = arrayList.get(position);

                versos = (ArrayList<Versos>) versosDAO.retornaVersos(livro.getPK());
                capitulos.clear();
                for (int i = 0; i < versos.size(); i++){

                    capitulos.add(String.valueOf( versos.get(i).getCapitulo()));
                    textoVersos.add(versos.get(i).getVerso());
                }
                listaVersos.setAdapter(new AdapterVersos(versos,getContext(),getActivity()));

                Set set = new HashSet(capitulos);
                capitulos.clear();
                capitulos.addAll(set);

                ArrayAdapter adapterCapitulos = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_dropdown_item,capitulos);
                adapterCapitulos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spnCapitulos.setAdapter(adapterCapitulos);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        RecyclerView.LayoutManager layout = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        listaVersos.setLayoutManager(layout);

        listaVersos.setAdapter(new AdapterVersos(versos,getContext(),getActivity()));

        return root;
    }
}