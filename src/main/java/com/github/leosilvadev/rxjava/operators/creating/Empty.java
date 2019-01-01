package com.github.leosilvadev.rxjava.operators.creating;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;

public class Empty {

    public static void main(String[] args) {
        Maybe.empty().subscribe(
                System.out::println,
                ex -> ex.printStackTrace(),
                () -> System.out.println("Completed!"));
    }
}
