package com.github.leosilvadev.rxjava.exercise1.services;

import com.github.leosilvadev.rxjava.exercise1.domains.Product;
import io.reactivex.Maybe;
import io.reactivex.Observable;

import java.math.BigDecimal;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class RxProductService {

    private final LinkedBlockingDeque<Product> products;

    public RxProductService() {
        this.products = new LinkedBlockingDeque<>();
        this.products.add(new Product(1L, "Product 1", new BigDecimal(150)));
    }

    public Maybe<Product> findProduct(final Long id) {
        return Maybe.timer(1, TimeUnit.SECONDS)
                .flatMapObservable(i -> Observable.fromIterable(products))
                .filter(p -> id.equals(p.getId()))
                .firstElement();
    }
}
