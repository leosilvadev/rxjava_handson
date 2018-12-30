package com.github.leosilvadev.rxjava.operators.creating;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class Interval {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Started " + Thread.currentThread().getName());
        Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(n -> {
                    System.out.println("New event " + n + " " + Thread.currentThread().getName());
                });
        System.out.println("Finished " + Thread.currentThread().getName());
        Thread.sleep(10_000);
    }
}
