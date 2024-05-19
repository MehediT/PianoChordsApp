package com.example.pianochordsapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pianochordsapp.R;
import com.example.pianochordsapp.entities.Setting;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class ChordsFragment extends Fragment {

    public ChordsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chord_part, container, false);
    }

    public void startGame(Setting setting) {
        // TODO create game
    }

    public void endGame() {
        // TODO end game
    }
}