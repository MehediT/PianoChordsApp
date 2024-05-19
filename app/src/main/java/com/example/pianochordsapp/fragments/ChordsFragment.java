package com.example.pianochordsapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pianochordsapp.R;
import com.example.pianochordsapp.entities.Chord;
import com.example.pianochordsapp.entities.ChordManager;
import com.example.pianochordsapp.entities.Setting;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class ChordsFragment extends Fragment {

    Thread gameloop;

    TextView diese_bemol_text;
    TextView chord_text;
    TextView minor_text;
    TextView reset;
    private boolean isGameRunning;
    private Handler handler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View result = inflater.inflate(R.layout.fragment_chord_part, container, false);
        diese_bemol_text = result.findViewById(R.id.diese_bemol_text);
        chord_text = result.findViewById(R.id.chord_text);
        minor_text = result.findViewById(R.id.minor_text);

        return result;
    }

    public void startGame(Setting setting) {
        Log.println(Log.INFO, "Start Game", "Game is running...");
        ChordManager chordManager = new ChordManager(setting);
        chord_text.setVisibility(View.VISIBLE);
        minor_text.setVisibility(setting.isMinor() ? View.VISIBLE : View.INVISIBLE);
        diese_bemol_text.setVisibility(setting.isBemol_diese() ? View.VISIBLE : View.INVISIBLE);

        // Initialize handler to post messages to the UI thread
        handler = new Handler();

        isGameRunning = true;
        gameloop = new Thread(new Runnable() {
            @Override
            public void run() {
                while (isGameRunning) {
                    Log.println(Log.INFO, "Game running", "New chord...");
                    Chord newChord = chordManager.getNewChord();

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            chord_text.setText(newChord.getValue());
                            minor_text.setText(newChord.isMinor() ? "m" : "");
                            diese_bemol_text.setText(newChord.isSharp() ? "#" : newChord.isFlat() ? "b" : "");
                        }
                    });

                    try {
                        Thread.sleep(setting.getDelay());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        gameloop.start();
    }

    public void endGame() {
        isGameRunning = false; // Set flag to stop the game loop
        chord_text.setVisibility(View.INVISIBLE);
        minor_text.setVisibility(View.INVISIBLE);
        diese_bemol_text.setVisibility(View.INVISIBLE);

    }
}