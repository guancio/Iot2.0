package se.kth.roberto.iot20;

/**
 * Created by guancio on 14/11/2017.
 */

public class SwitchController {
    private SwitchModel stateOfSwitch;
    public SwitchController() {
        this.stateOfSwitch = new SwitchModel();
    }

    public void turnOn() throws SwitchWrongCommand {
        if (this.stateOfSwitch.isOn())
            throw new SwitchWrongCommand(true);
        // Blouetooth comunication with the IoT device
        this.stateOfSwitch.setOn(true);
        this.stateOfSwitch.setVdata(5);
    }

    public void turnOff() throws SwitchWrongCommand {
        if (!this.stateOfSwitch.isOn())
            throw new SwitchWrongCommand(false);
        // Blouetooth comunication with the IoT device
        this.stateOfSwitch.setOn(false);
        this.stateOfSwitch.setVdata(0);
    }

    public double read() {
        return this.stateOfSwitch.getVdata();
    }
}
