package com.github.leosilvadev.rxjava.operators.creating;

import io.reactivex.Single;

public class Defer {

    public static void main(String[] args) {
        Single<Integer> integerSingle = Single.just(10)
                .filter(n -> n > 10)
                .toSingle()
                .flatMap(n -> getId(n));

        integerSingle.subscribe(System.out::println);
    }

    public static Single<Integer> getId(Integer oldId) {
        return Single.defer(() -> Single.just(oldId + 1));
    }
}
