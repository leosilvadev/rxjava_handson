package com.github.leosilvadev.rxjava.exercise1;

import com.github.leosilvadev.rxjava.exercise1.domains.Order;
import com.github.leosilvadev.rxjava.exercise1.domains.OrderCreatedEvent;
import com.github.leosilvadev.rxjava.exercise1.services.*;
import org.apache.commons.lang3.tuple.Pair;

public class RxExercise1 {

    public static void main(final String[] args) throws InterruptedException {
        RxProductService productService = new RxProductService();
        RxUserService userService = new RxUserService();
        RxOrderService orderService = new RxOrderService();
        RxEventService eventService = new RxEventService();
        RxPublisher publisher = new RxPublisher();

        userService.findUser("admin@admin.com")
            .flatMap(user -> productService.findProduct(1L).map(product -> Pair.of(product, user)))
            .map(pair -> new Order(pair.getRight()).addProduct(pair.getLeft(), 10).generateId())
                .flatMapSingle(orderService::checkout)
            .map(OrderCreatedEvent::new)
            .flatMap(eventService::save)
            .flatMap(publisher::publish)
            .subscribe();

        Thread.sleep(10_000);
    }
}
