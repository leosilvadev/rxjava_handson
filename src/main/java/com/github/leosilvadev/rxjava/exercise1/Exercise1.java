package com.github.leosilvadev.rxjava.exercise1;

import com.github.leosilvadev.rxjava.exercise1.domains.Order;
import com.github.leosilvadev.rxjava.exercise1.services.OrderService;
import com.github.leosilvadev.rxjava.exercise1.services.ProductService;
import com.github.leosilvadev.rxjava.exercise1.services.Publisher;
import com.github.leosilvadev.rxjava.exercise1.services.Publisher.OrderCreatedEvent;
import com.github.leosilvadev.rxjava.exercise1.services.UserService;

public class Exercise1 {

    public static void main(final String[] args) {
        ProductService productService = new ProductService();
        UserService userService = new UserService();
        OrderService orderService = new OrderService();
        Publisher publisher = new Publisher();

        userService.findUser("admin@admin.com", user -> {
            productService.findProduct(1L, product -> {
                Order order = new Order(user).addProduct(product, 10).generateId();
                orderService.checkout(order, persistedOrder -> {
                    OrderCreatedEvent event = new OrderCreatedEvent(persistedOrder);
                    publisher.publish(event);
                });
            });
        });
    }
}
