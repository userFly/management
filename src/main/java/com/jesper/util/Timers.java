package com.jesper.util;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by jiangyunxiong on 2018/4/14.
 */
public class Timers implements Runnable {
    @Override
    public void run() {

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                RunnableThreadWebCount.showthread();
            }
        };

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, 1000, 3000);
    }
}
