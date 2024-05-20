package com.example.pianochordsapp.entities;

public class Setting {

    private int delay_milisecond = 5000;
    private boolean bemol_diese = false;
    private boolean minor = false;
    private boolean french_mode = false;

    public Setting() {
        this.delay_milisecond = 5000;
        this.bemol_diese = false;
        this.minor = false;
        this.french_mode = false;
    }

    public Setting(int delay_milisecond, boolean bemol_diese, boolean minor) {
        this.delay_milisecond = delay_milisecond;
        this.bemol_diese = bemol_diese;
        this.minor = minor;
        this.french_mode = french_mode;
    }
    public Setting(int delay_milisecond, boolean bemol_diese, boolean minor, boolean bonus) {
        this.delay_milisecond = delay_milisecond;
        this.bemol_diese = bemol_diese;
        this.minor = minor;
        this.french_mode = bonus;
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

    public boolean isFrench_mode() {
        return french_mode;
    }

    public void setFrench_mode(boolean french_mode) {
        this.french_mode = french_mode;
    }
}
