package com.example.pianochordsapp.entities;

public class Setting {

    public int delay = 5;
    public boolean bemol_diese = false;
    public boolean minor = false;
    public boolean bonus = false;

    public Setting() {
        this.delay = 5;
        this.bemol_diese = false;
        this.minor = false;
        this.bonus = false;
    }

    public Setting(int delay, boolean bemol_diese, boolean minor) {
        this.delay = delay;
        this.bemol_diese = bemol_diese;
        this.minor = minor;
        this.bonus = bonus;
    }
    public Setting(int delay, boolean bemol_diese, boolean minor, boolean bonus) {
        this.delay = delay;
        this.bemol_diese = bemol_diese;
        this.minor = minor;
        this.bonus = bonus;
    }


    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public boolean isBemol_diese() {
        return bemol_diese;
    }

    public void setBemol_diese(boolean bemol_diese) {
        this.bemol_diese = bemol_diese;
    }

    public boolean isMinor() {
        return minor;
    }

    public void setMinor(boolean minor) {
        this.minor = minor;
    }

    public boolean isBonus() {
        return bonus;
    }

    public void setBonus(boolean bonus) {
        this.bonus = bonus;
    }
}
