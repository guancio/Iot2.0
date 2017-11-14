package se.kth.roberto.iot20;

/**
 * Created by guancio on 14/11/2017.
 */

public class SwitchModel {
    private boolean on;
    private double vdata;

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getVdata() {
        return vdata;
    }

    public void setVdata(double vdata) {
        this.vdata = vdata;
    }

    public SwitchModel() {
        vdata = 0;
        on = false;
    }
}
