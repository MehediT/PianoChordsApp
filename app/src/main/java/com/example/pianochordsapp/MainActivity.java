package com.example.pianochordsapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pianochordsapp.entities.Setting;
import com.example.pianochordsapp.fragments.ChordsFragment;
import com.example.pianochordsapp.fragments.FooterFragment;
import com.example.pianochordsapp.fragments.HeaderFragment;

public class MainActivity extends AppCompatActivity implements HeaderFragment.OnStartButtonClickListener,HeaderFragment.OnResetButtonClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onStartButtonClicked() {
        // Launch something in ChordsPart fragment
        FooterFragment footerFragment = (FooterFragment) getSupportFragmentManager().findFragmentById(R.id.footer);
        if (footerFragment != null) {
            footerFragment.disableControl();
            Setting setting = footerFragment.getSetting();

            ChordsFragment chordsPart = (ChordsFragment) getSupportFragmentManager().findFragmentById(R.id.chords_part);
            if (chordsPart != null) {
                chordsPart.startGame(setting);
            }
        }

    }

    @Override
    public void onResetButtonClicked() {
        // Launch something in ChordsPart fragment
        ChordsFragment chordsPart = (ChordsFragment) getSupportFragmentManager().findFragmentById(R.id.chords_part);
        if (chordsPart != null) {
            chordsPart.endGame();
            FooterFragment footerFragment = (FooterFragment) getSupportFragmentManager().findFragmentById(R.id.footer);
            if (footerFragment != null) {
                footerFragment.enableControl();
            }
        }

    }
}

