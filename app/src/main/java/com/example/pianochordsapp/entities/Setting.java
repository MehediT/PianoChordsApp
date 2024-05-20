package com.example.pianochordsapp.entities;

public class Setting {

    private int delay_milisecond = 5000;
    private boolean sharp_flat = false;
    private boolean minor = false;
    private boolean french_mode = false;

    public Setting() {
        this.delay_milisecond = 5000;
        this.sharp_flat = false;
        this.minor = false;
        this.french_mode = false;
    }

    public Setting(int delay_milisecond, boolean sharp_flat, boolean minor) {
        this.delay_milisecond = delay_milisecond;
        this.sharp_flat = sharp_flat;
        this.minor = minor;
        this.french_mode = french_mode;
    }
    public Setting(int delay_milisecond, boolean sharp_flat, boolean minor, boolean bonus) {
        this.delay_milisecond = delay_milisecond;
        this.sharp_flat = sharp_flat;
        this.minor = minor;
        this.french_mode = bonus;
    }


    public int getDelay() {
        return delay_milisecond;
    }

    public void setDelay(int delay_milisecond) {
        this.delay_milisecond = delay_milisecond;
    }

    public boolean isSharp_flat() {
        return sharp_flat;
    }

    public void setSharp_flat(boolean sharp_flat) {
        this.sharp_flat = sharp_flat;
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
