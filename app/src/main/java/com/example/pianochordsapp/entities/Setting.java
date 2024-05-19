package com.example.pianochordsapp.entities;

public class Setting {

    private int delay_milisecond = 5000;
    private boolean bemol_diese = false;
    private boolean minor = false;
    private boolean bonus = false;

    public Setting() {
        this.delay_milisecond = 5000;
        this.bemol_diese = false;
        this.minor = false;
        this.bonus = false;
    }

    public Setting(int delay_milisecond, boolean bemol_diese, boolean minor) {
        this.delay_milisecond = delay_milisecond;
        this.bemol_diese = bemol_diese;
        this.minor = minor;
        this.bonus = bonus;
    }
    public Setting(int delay_milisecond, boolean bemol_diese, boolean minor, boolean bonus) {
        this.delay_milisecond = delay_milisecond;
        this.bemol_diese = bemol_diese;
        this.minor = minor;
        this.bonus = bonus;
    }


    public int getDelay() {
        return delay_milisecond;
    }

    public void setDelay(int delay_milisecond) {
        this.delay_milisecond = delay_milisecond;
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
