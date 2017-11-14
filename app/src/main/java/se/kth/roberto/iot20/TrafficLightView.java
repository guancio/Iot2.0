package se.kth.roberto.iot20;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;

import java.util.List;

/**
 * Created by guancio on 14/11/2017.
 */

public class TrafficLightView extends View {
    private boolean isActivated;
    private TrafficLightListener eventHandler;

    public TrafficLightView(Context context) {
        super(context);
        isActivated = false;
        eventHandler = null;
    }

    public void setListener(TrafficLightListener param) {
        this.eventHandler = param;
    }


    public void onDraw(Canvas canvas) {
        Paint black = new Paint();
        Paint red = new Paint();
        Paint green = new Paint();

        red.setARGB(255, 128, 0, 0);
        green.setARGB(255, 0, 128, 0);

        if (isActivated) {
            green.setARGB(255, 0, 255, 0);
        }
        else {
            red.setARGB(255, 255, 0, 0);
        }

        RectF rect = new RectF(0, 0, this.getWidth(), this.getHeight());
        canvas.drawRect(rect, black);

        float smallerV = 0;
        if (this.getWidth()<this.getHeight()/2)
            smallerV = this.getWidth();
        else
            smallerV = this.getHeight()/2;

        canvas.drawCircle(this.getWidth()/2, this.getHeight()/4, smallerV/2, red);
        canvas.drawCircle(this.getWidth()/2, this.getHeight()*3/4, smallerV/2, green);
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            if (this.eventHandler == null)
                return true;
            if (event.getY() < this.getHeight()/2) {
                isActivated = false;
                eventHandler.onClick(false);
            }
            else {
                isActivated = true;
                eventHandler.onClick(true);
            }
            this.invalidate();
        }
        return true;
    }
}
