package se.kth.roberto.iot20;

/**
 * Created by guancio on 14/11/2017.
 */

public class SwitchWrongCommand extends  Exception {
    public SwitchWrongCommand(boolean settingOn) {
        super("This command has been sent twice: " + (settingOn?"ON":"OFF"));
    }
}
