package com.github.leosilvadev.rxjava.exercise1.services;

import com.github.leosilvadev.rxjava.exercise1.domains.Order;
import io.reactivex.Single;

import java.util.concurrent.TimeUnit;

public class RxOrderService {

    public Single<Order> checkout(final Order order) {
        return Single.timer(3, TimeUnit.SECONDS)
                .map(i -> {
                    final Order orderReady = order.generateId();
                    System.out.println(String.format("Checkout the order with id %s", order.getId()));
                    return orderReady;
                });
    }

}
