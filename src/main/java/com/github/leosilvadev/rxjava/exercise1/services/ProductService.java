package com.github.leosilvadev.rxjava.exercise1.services;

import com.github.leosilvadev.rxjava.exercise1.domains.Product;
import com.github.leosilvadev.rxjava.util.Delay;

import java.math.BigDecimal;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.function.Consumer;

public class ProductService {

    private final LinkedBlockingDeque<Product> products;

    public ProductService() {
        this.products = new LinkedBlockingDeque<>();
        products.add(new Product(1L, "Product 1", new BigDecimal(150)));
    }

    public void findProduct(final Long id, final Consumer<Product> callback) {
        Delay.run(2000L, () -> {
            products.stream()
                    .filter(p -> id.equals(p.getId()))
                    .findFirst()
                    .ifPresent(callback);
        });
    }
}
