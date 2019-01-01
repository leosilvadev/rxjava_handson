package com.github.leosilvadev.rxjava.exercise1;

import java.util.Timer;
import java.util.TimerTask;

public class Delay {

    private static final Timer timer = new Timer();

    public static void run(final Long time, final Runnable function) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                function.run();
            }
        }, time);
    }

}
