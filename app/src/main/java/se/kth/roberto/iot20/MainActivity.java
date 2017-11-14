package se.kth.roberto.iot20;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TrafficLightListener {

    private SwitchController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout mLinearLayout = new LinearLayout(this);

        // Instantiate our custom View and define its properties
        TrafficLightView tf = new TrafficLightView(this);
        tf.setListener(this);
        controller = new SwitchController();
        
        // Add the View to the layout and set the layout as the content view
        mLinearLayout.addView(tf);
        setContentView(mLinearLayout);
    }

    @Override
    public void onClick(boolean activated) {
        try {
            if (activated)
                controller.turnOn();
            else
                controller.turnOff();
        } catch (SwitchWrongCommand switchWrongCommand) {
            Toast t = Toast.makeText(this, "You pressed the wrong button", Toast.LENGTH_SHORT);
            t.show();
        }
    }
}
