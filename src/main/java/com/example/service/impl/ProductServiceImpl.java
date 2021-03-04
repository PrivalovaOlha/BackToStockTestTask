package com.example.service.impl;

import com.example.db.Stock;
import com.example.entity.Product;
import com.example.service.NotificationService;
import com.example.service.ProductService;

import java.util.Map;
import java.util.Objects;

public class ProductServiceImpl implements ProductService {

    private final Stock stock = Stock.getInstance();
    private final NotificationService notificationService = new NotificationServiceImpl();

    public Long fillUpProduct(Product product, Long quantity) {
        Objects.requireNonNull(product, "Product can`t be null");
        Objects.requireNonNull(quantity, "Quantity of product can`t be null");

        Map<Product, Long> allProduct = stock.getProducts();

        if (allProduct.get(product) == 0) {
            notificationService.notifyUserByProduct(product);
        }

        return allProduct.computeIfPresent(product, (key, val) -> val + quantity);
    }
}
