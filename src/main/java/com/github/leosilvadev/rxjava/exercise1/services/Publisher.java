package com.github.leosilvadev.rxjava.exercise1.services;

import com.github.leosilvadev.rxjava.exercise1.domains.OrderCreatedEvent;

public class Publisher {

    public void publish(final OrderCreatedEvent event) {
        System.out.println("Order created, generating event...");
        //...
    }

}
