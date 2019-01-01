package com.github.leosilvadev.rxjava.operators.creating;

import io.reactivex.Observable;
import io.reactivex.Single;

public class Create {

    public static void main(String[] args) {
        Observable<Object> obs = Observable.create(emitter -> {
            throw new RuntimeException("bla");
        });

        obs.subscribe(System.out::println, ex -> System.out.println(ex.getMessage()));
    }
}
