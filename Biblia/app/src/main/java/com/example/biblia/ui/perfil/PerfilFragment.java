package com.example.biblia.ui.perfil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.biblia.R;
import com.example.biblia.data.PerfilDAO;
import com.example.biblia.entity.Perfil;

import java.util.Date;

public class PerfilFragment extends Fragment {

    private PerfilViewModel perfilViewModel;

    private EditText txtNome;
    private EditText txtIgreja;
    private EditText txtNomePastor;
    private EditText txtDataBatismo;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        perfilViewModel =
                new ViewModelProvider(this).get(PerfilViewModel.class);
        View root = inflater.inflate(R.layout.fragment_perfil, container, false);

        txtNome = root.findViewById(R.id.txtPerfilNome);
        txtIgreja = root.findViewById(R.id.txtPerfilIgreja);
        txtNomePastor = root.findViewById(R.id.txtPerfilNomePastor);


        PerfilDAO perfilDAO = new PerfilDAO(getContext());

        Perfil perfil = perfilDAO.retornaPerfil();

        if (perfil != null){
            txtNome.setText(perfil.getNome());
            txtIgreja.setText(perfil.getIgreja());
            txtNomePastor.setText(perfil.getNomePastor());

        }

        return root;
    }

    @Override
    public void onStop() {
        super.onStop();

        Perfil perfil = new Perfil();

        perfil.setNome(txtNome.getText().toString());
        perfil.setIgreja(txtIgreja.getText().toString());
        perfil.setNomePastor(txtNomePastor.getText().toString());

        PerfilDAO perfilDAO = new PerfilDAO(getContext());

        perfilDAO.editarPerfil(perfil);

    }

}