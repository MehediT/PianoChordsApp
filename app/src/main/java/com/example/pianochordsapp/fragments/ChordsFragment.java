package com.example.pianochordsapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
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
    Thread chrono;

    TextView sharp_flat_text;
    TextView chord_text;
    TextView minor_text;
    TextView reset;
    private boolean isGameRunning;
    private Handler handler;
    private ProgressBar progessBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View result = inflater.inflate(R.layout.fragment_chord_part, container, false);
        sharp_flat_text = result.findViewById(R.id.sharp_flat_text);
        chord_text = result.findViewById(R.id.chord_text);
        minor_text = result.findViewById(R.id.minor_text);
        progessBar = result.findViewById(R.id.progressBar);

        return result;
    }

    public void startGame(Setting setting) {
        Log.println(Log.INFO, "Start Game", "Game is running...");
        ChordManager chordManager = new ChordManager(setting);

        progessBar.setMax(setting.getDelay());
        handler = new Handler();

        isGameRunning = true;

        gameloop = new Thread(new Runnable() {
            @Override
            public void run() {
                while (isGameRunning) {
                    Log.println(Log.INFO, "Game running", "New chord...");
                    Chord newChord = chordManager.getNewChord();
                    progessBar.setProgress(setting.getDelay());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            if(setting.isFrench_mode())
                                chord_text.setText(newChord.getFrenchValue());
                            else
                                chord_text.setText(newChord.getValue());
                            minor_text.setText(newChord.isMinor() ? "m" : "");
                            sharp_flat_text.setText(newChord.isSharp() ? "#" : newChord.isFlat() ? "b" : "");
                        }
                    });
                    chrono = startProgressBar();
                    try {
                        Thread.sleep(setting.getDelay());
                        chrono.interrupt();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        gameloop.start();
        chord_text.setVisibility(View.VISIBLE);
        minor_text.setVisibility(setting.isMinor() ? View.VISIBLE : View.INVISIBLE);
        sharp_flat_text.setVisibility(setting.isSharp_flat() ? View.VISIBLE : View.INVISIBLE);
        progessBar.setVisibility(View.VISIBLE);
    }

    public Thread startProgressBar()
    {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (progessBar.getProgress() > 0) {
                        progessBar.setProgress(progessBar.getProgress()-progessBar.getMax()/300);
                        Log.println(Log.INFO, "cmpt", "progress "+progessBar.getProgress());
                        Thread.sleep(progessBar.getMax()/300);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        return thread;
    }
    public void endGame() {
        isGameRunning = false; // Set flag to stop the game loop
        gameloop.interrupt();
        chrono.interrupt();
        chord_text.setVisibility(View.INVISIBLE);
        minor_text.setVisibility(View.INVISIBLE);
        sharp_flat_text.setVisibility(View.INVISIBLE);
        progessBar.setVisibility(View.INVISIBLE);

        chord_text.setText("");
        minor_text.setText("");
        sharp_flat_text.setText("");
    }
}