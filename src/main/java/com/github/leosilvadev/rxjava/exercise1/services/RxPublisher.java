package com.github.leosilvadev.rxjava.exercise1.services;

import com.github.leosilvadev.rxjava.exercise1.domains.OrderCreatedEvent;
import io.reactivex.Single;

public class RxPublisher {

    public Single<OrderCreatedEvent> publish(final OrderCreatedEvent event) {
        return Single.create(emitter -> {
            System.out.println("Order created, generating event...");
            //...
            //...
            //...
            emitter.onSuccess(event);
        });
    }

}
