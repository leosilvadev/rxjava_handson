package com.github.leosilvadev.rxjava.exercise1.domains;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {

    private final String id;
    private final User buyer;
    private final List<ProductOrder> items;

    public Order(final User buyer) {
        this.id = null;
        this.buyer = buyer;
        this.items = new ArrayList<>();
    }

    private Order(final String id,
                  final User buyer,
                  final List<ProductOrder> items) {
        this.id = id;
        this.buyer = buyer;
        this.items = items;
    }

    public Order generateId() {
        return new Order(UUID.randomUUID().toString(), buyer, items);
    }

    public String getId() {
        return id;
    }

    public User getBuyer() {
        return buyer;
    }

    public List<ProductOrder> getItems() {
        return items;
    }

    public Order addProduct(final Product product, final Integer quantity) {
        getItems().add(new ProductOrder(product, quantity));
        return this;
    }

    public static class ProductOrder {
        private final Product product;
        private final Integer quantity;

        public ProductOrder(final Product product, final Integer quantity) {
            this.product = product;
            this.quantity = quantity;
        }

        public Product getProduct() {
            return product;
        }

        public Integer getQuantity() {
            return quantity;
        }
    }
}
