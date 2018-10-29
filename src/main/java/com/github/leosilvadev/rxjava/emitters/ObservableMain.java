package com.github.leosilvadev.rxjava.emitters;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class ObservableMain {

    public static void main(String[] args) {
        ConnectableObservable<Integer> connectable = Observable.range(10, 10)
                .doOnNext(System.out::println).publish();
        connectable.connect();
    }
}
