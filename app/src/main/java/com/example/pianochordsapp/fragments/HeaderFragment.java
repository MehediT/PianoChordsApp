package com.example.pianochordsapp.fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.pianochordsapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class HeaderFragment extends Fragment {

    private Button start;
    private Button reset;

    private OnStartButtonClickListener callbackStart;
    private OnResetButtonClickListener callbackReset;

    public interface OnStartButtonClickListener {
        void onStartButtonClicked();
    }
    public interface OnResetButtonClickListener {
        void onResetButtonClicked();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            callbackReset = (OnResetButtonClickListener) context;
            callbackStart = (OnStartButtonClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnStartButtonClickListener and OnResetButtonClickListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.fragment_header, container, false);

        start = result.findViewById(R.id.start);
        reset = result.findViewById(R.id.reset);

        start.setEnabled(true);
        reset.setEnabled(false);
        setButtonAction();
        return result;
    }

    public void setButtonAction(){
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ;
                start.setBackgroundColor(getResources().getColor(R.color.grey));
                start.setBackgroundColor(getResources().getColor(R.color.grey));
                start.setEnabled(false);

                reset.setBackgroundColor(getResources().getColor(R.color.purple));
                reset.setTextColor(getResources().getColor(R.color.white));
                reset.setEnabled(true);

                callbackStart.onStartButtonClicked();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset.setBackgroundColor(getResources().getColor(R.color.grey));
                reset.setBackgroundColor(getResources().getColor(R.color.grey));
                reset.setEnabled(false);

                start.setBackgroundColor(getResources().getColor(R.color.purple));
                start.setTextColor(getResources().getColor(R.color.white));
                start.setEnabled(true);
                callbackReset.onResetButtonClicked();
            }
        });
    }
}