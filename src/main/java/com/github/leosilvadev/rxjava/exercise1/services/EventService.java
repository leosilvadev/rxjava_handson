package com.github.leosilvadev.rxjava.exercise1.services;

import com.github.leosilvadev.rxjava.exercise1.Delay;
import com.github.leosilvadev.rxjava.exercise1.domains.OrderCreatedEvent;

import java.util.function.Consumer;

public class EventService {

    public void save(final OrderCreatedEvent event, final Consumer<String> callback) {
        Delay.run(200L, () -> {
            callback.accept(event.generateId().getId());
        });
    }

}
