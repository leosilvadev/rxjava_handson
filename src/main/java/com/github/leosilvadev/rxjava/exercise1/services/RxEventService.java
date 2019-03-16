package com.github.leosilvadev.rxjava.exercise1.services;

import com.github.leosilvadev.rxjava.exercise1.domains.OrderCreatedEvent;
import io.reactivex.Single;

import java.util.concurrent.TimeUnit;

public class RxEventService {

    public Single<OrderCreatedEvent> save(final OrderCreatedEvent event) {
        return Single.timer(2, TimeUnit.SECONDS)
                .map(i -> event.generateId());
    }

}
