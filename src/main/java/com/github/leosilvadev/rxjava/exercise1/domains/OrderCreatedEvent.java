package com.github.leosilvadev.rxjava.exercise1.domains;

import java.util.UUID;

public class OrderCreatedEvent {
    private final String id;
    private final Order order;

    public OrderCreatedEvent(final Order order) {
        this(null, order);
    }

    public OrderCreatedEvent(final String id, final Order order) {
        this.id = id;
        this.order = order;
    }

    public OrderCreatedEvent generateId() {
        return new OrderCreatedEvent(UUID.randomUUID().toString(), order);
    }

    public Order getOrder() {
        return order;
    }

    public String getId() {
        return id;
    }
}
