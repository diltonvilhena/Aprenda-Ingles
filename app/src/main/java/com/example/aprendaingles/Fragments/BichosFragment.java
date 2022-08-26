package com.example.aprendaingles.Fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.aprendaingles.R;

public class BichosFragment extends Fragment implements View.OnClickListener {

    private ImageButton buttonCao, buttonGato, buttonLeao,
            buttonMacaco, buttonOvelha, buttonVaca;

    private MediaPlayer mediaPlayer;


    public BichosFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bichos, container, false);

        buttonCao = view.findViewById(R.id.ButtonCao);
        buttonGato = view.findViewById(R.id.ButtonGato);
        buttonLeao = view.findViewById(R.id.ButtonLeao);
        buttonMacaco = view.findViewById(R.id.ButtonMacaco);
        buttonOvelha = view.findViewById(R.id.ButtonOvelha);
        buttonVaca = view.findViewById(R.id.ButtonVaca);


        //verifica o clique em cada botão
        buttonCao.setOnClickListener(this);
        buttonGato.setOnClickListener(this);
        buttonLeao.setOnClickListener(this);
        buttonMacaco.setOnClickListener(this);
        buttonOvelha.setOnClickListener(this);
        buttonVaca.setOnClickListener(this);


        return view;
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.ButtonCao:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.dog);
                tocarSom();
                break;

            case R.id.ButtonGato:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cat);
                tocarSom();
                break;

            case R.id.ButtonLeao:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.lion);
                tocarSom();
                break;

            case R.id.ButtonMacaco:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.monkey);
                tocarSom();
                break;

            case R.id.ButtonOvelha:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.sheep);
                tocarSom();
                break;

            case R.id.ButtonVaca:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.cow);
                tocarSom();
                break;
        }
    }

    public void tocarSom(){
         if (mediaPlayer != null){
             mediaPlayer.start();

             mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                 @Override
                 public void onCompletion(MediaPlayer mediaPlayer) {
                     mediaPlayer.release();
                 }
             });
         }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}