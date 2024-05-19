package com.example.pianochordsapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.Switch;


import com.example.pianochordsapp.R;
import com.example.pianochordsapp.entities.Setting;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class FooterFragment extends Fragment {

    Setting setting ;

    private RadioButton radio5;
    private RadioButton radio10;
    private RadioButton radio15;

    private Switch minor;
    private Switch diese_bemol;

    public void enableControl() {
        radio5.setEnabled(true);
        radio10.setEnabled(true);
        radio15.setEnabled(true);
        minor.setEnabled(true);
        diese_bemol.setEnabled(true);
    }

    public void disableControl() {
        radio5.setEnabled(false);
        radio10.setEnabled(false);
        radio15.setEnabled(false);
        minor.setEnabled(false);
        diese_bemol.setEnabled(false);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View result = inflater.inflate(R.layout.fragment_footer, container, false);

        radio5 = result.findViewById(R.id.five);
        radio10 = result.findViewById(R.id.ten);
        radio15 = result.findViewById(R.id.fifteen);

        minor = result.findViewById(R.id.minor_switch);
        diese_bemol = result.findViewById(R.id.diese_bemol_switch);

        setting = getSetting();

        return result;
    }

    public Setting getSetting() {
        if(setting == null)
            setting = new Setting();

        if(radio5.isChecked())
            setting.setDelay(5);
        else if(radio10.isChecked())
            setting.setDelay(10);
        else
            setting.setDelay(15);

        setting.setMinor(minor.isChecked());
        setting.setMinor(diese_bemol.isChecked());

        return setting;
    }
}