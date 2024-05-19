package com.example.pianochordsapp.entities;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ChordManager {

    private Setting setting;

    private Chord lastChord;
    public ChordManager(Setting setting) {
        this.setting = setting;
    }
    public Chord getNewChord() {

        Stream<Chord> chords = Arrays.stream(Chord.values());

        chords = chords.filter(c -> !c.isMinor() || c.isMinor() == setting.isMinor())
                        .filter(c -> !c.isFlat() || c.isFlat() == setting.isBemol_diese())
                        .filter(c -> !c.isSharp() || c.isSharp() == setting.isBemol_diese())
                        .filter(c -> c!=lastChord);

        List<Chord> filtred = chords.collect(Collectors.toList());;

        lastChord = filtred.get((new Random().nextInt(filtred.size())));
        return lastChord;
    }
}
