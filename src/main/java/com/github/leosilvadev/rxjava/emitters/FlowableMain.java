package com.github.leosilvadev.rxjava.emitters;

import io.reactivex.Flowable;
import io.reactivex.flowables.ConnectableFlowable;

public class FlowableMain {

    public static void main(String[] args) {
        ConnectableFlowable<Integer> connectable = Flowable.range(10, 10)
                .map(n -> n + 10)
                .doOnNext(System.out::println).publish();
        connectable.connect();
    }
}
