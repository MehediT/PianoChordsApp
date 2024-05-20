package com.example.pianochordsapp.entities;

public enum Chord {
    //DO
    C_MAJOR("C", "Do", false, false, false),
    C_MINOR("C", "Do", true, false, false),
    C_MAJOR_SHARP("C", "Do", false, false, true),
    C_MINOR_SHARP("C", "Do", true, false, true),
    //RE
    D_MAJOR_FLAT("D", "Ré", false, true, false),
    D_MINOR_FLAT("D", "Ré", true, true, false),
    D_MAJOR("D", "Ré", false, false, false),
    D_MINOR("D", "Ré", true, false, false),
    D_MAJOR_SHARP("D", "Ré", false, false, true),
    D_MINOR_SHARP("D", "Ré", true, false, true),
    //MI
    E_MAJOR_FLAT("E", "Mi", false, true, false),
    E_MINOR_FLAT("E", "Mi", true, true, false),
    E_MAJOR("E", "Mi", false, false, false),
    E_MINOR("E", "Mi", true, false, false),
    //FA
    F_MAJOR("F", "Fa", false, false, false),
    F_MINOR("F", "Fa", true, false, false),
    F_MAJOR_SHARP("F", "Fa", false, false, true),
    F_MINOR_SHARP("F", "Fa", true, false, true),
    //SOL
    G_MAJOR_FLAT("G", "Sol", false, true, false),
    G_MINOR_FLAT("G", "Sol", true, true, false),
    G_MAJOR("G", "Sol", false, false, false),
    G_MINOR("G", "Sol", true, false, false),
    G_MINOR_SHARP("G", "Sol", true, false, true),
    G_MAJOR_SHARP("G", "Sol", false, false, true),
    //LA
    A_MINOR_FLAT("A", "La", true, true, false),
    A_MAJOR_FLAT("A", "La", false, true, false),
    A_MAJOR("A", "La", false, false, false),
    A_MINOR("A", "La", true, false, false),
    A_MAJOR_SHARP("A", "La", false, false, true),
    A_MINOR_SHARP("A", "La", true, false, true),
    //SI
    B_MAJOR_FLAT("B", "Si", false, true, false),
    B_MINOR_FLAT("B", "Si", true, true, false),
    B_MAJOR("B", "Si", false, false, false),
    B_MINOR("B", "Si", true, false, false);

    private final String value;

    // S'il y aurait u plusieurs langues j'aurais fait une ressource manager pour changer le texte via cette classe
    private final String frenchvalue;

    private final boolean isMinor;
    private final boolean isFlat;
    private final boolean isSharp;
    Chord(String value, String frenchvalue, boolean isMinor, boolean isFlat, boolean isSharp) {
        this.value = value;
        this.frenchvalue = frenchvalue;
        this.isMinor = isMinor;
        this.isFlat = isFlat;
        this.isSharp = isSharp;
    }
    public String getValue() {
        return value;
    }
    public String getFrenchValue() {
        return frenchvalue;
    }

    public boolean isMinor() {
        return isMinor;
    }
    public boolean isFlat() {
        return isFlat;
    }
    public boolean isSharp() {
        return isSharp;
    }


}