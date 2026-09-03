package com.directi.training.isp.exercise_refactored;

import java.util.TimerTask;

public class Timer
{
    public void register(long timeOut, final TimeOutListener listener)
    {
        java.util.Timer timerUtility = new java.util.Timer();
        timerUtility.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                listener.timeOutCallback();
            }
        }, timeOut);
    }
}
