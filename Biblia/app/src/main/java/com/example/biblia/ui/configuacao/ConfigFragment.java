package com.example.biblia.ui.configuacao;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.biblia.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ConfigFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConfigFragment extends Fragment {

    private SeekBar seekTamanhoFonte;
    private TextView txtExemploFonte;
    private ImageButton imgbtnSalvar;

    public ConfigFragment() {
        // Required empty public constructor

    }

    public static ConfigFragment newInstance(String param1, String param2) {
        ConfigFragment fragment = new ConfigFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_config, container, false);

        seekTamanhoFonte = v.findViewById(R.id.seek_TamanhoFonte);
        txtExemploFonte  = v.findViewById(R.id.txtConfigExFonte);
        imgbtnSalvar     = v.findViewById(R.id.imgbtn_SalvarConfig);

        seekTamanhoFonte.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtExemploFonte.setTextSize(seekTamanhoFonte.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        imgbtnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvaConfig();
            }
        });

        return  v;
    }

    private void salvaConfig(){
        SharedPreferences sharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor shEditor = sharedPreferences.edit();
        shEditor.putInt("TamanhoFonte",seekTamanhoFonte.getProgress());
        shEditor.commit();

    }

}