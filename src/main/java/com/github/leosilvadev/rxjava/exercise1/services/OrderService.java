package com.github.leosilvadev.rxjava.exercise1.services;

import com.github.leosilvadev.rxjava.exercise1.domains.Order;
import com.github.leosilvadev.rxjava.util.Delay;

import java.util.function.Consumer;

public class OrderService {

    public void checkout(final Order order, final Consumer<Order> callback) {
        Delay.run(3000L, () -> {
            final Order orderReady = order.generateId();
            System.out.println(String.format("Checkout the order with id %s", order.getId()));
            callback.accept(orderReady);
        });
    }

}
