package com.github.leosilvadev.rxjava.exercise1.services;

import com.github.leosilvadev.rxjava.exercise1.domains.Order;

public class Publisher {

    public void publish(final OrderCreatedEvent event) {
        System.out.println("Order created, generating event...");
        //...
    }

    public static class OrderCreatedEvent {
        private final Order order;

        public OrderCreatedEvent(final Order order) {
            this.order = order;
        }

        public Order getOrder() {
            return order;
        }
    }

}
