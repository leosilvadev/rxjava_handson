package com.github.leosilvadev.rxjava.operators.creating;

import io.reactivex.Maybe;

import java.util.concurrent.TimeUnit;

public class Timer {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Started " + Thread.currentThread().getName());
        Maybe.timer(1, TimeUnit.SECONDS).subscribe(n -> {
            System.out.println("New event " + n + " " + Thread.currentThread().getName());
        });
        System.out.println("Finished " + Thread.currentThread().getName());
        Thread.sleep(10_000);
    }
}
