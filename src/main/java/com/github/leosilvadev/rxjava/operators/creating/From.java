package com.github.leosilvadev.rxjava.operators.creating;

import io.reactivex.Observable;
import io.reactivex.Single;

public class From {

    public static void main(String[] args) {
        Observable.fromArray(1,2,3,4).subscribe(System.out::println);
    }
}
