package com.directi.training.isp.exercise_refactored;

import java.util.Random;

public class Sensor
{
    public void register(ProximityListener listener)
    {
        while (true) {
            if (isPersonClose()) {
                listener.proximityCallback();
                break;
            }
        }
    }

    private boolean isPersonClose()
    {
        return new Random().nextBoolean();
    }
}
