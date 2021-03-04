package com.example.service.impl;

import com.example.db.Stock;
import com.example.entity.Product;
import com.example.entity.User;
import com.example.service.UserService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private final Stock stock = Stock.getInstance();

    @Override
    public boolean subscribe(User user, Product product) {
        Objects.requireNonNull(user, "User can`t be null");
        Objects.requireNonNull(product, "Product can`t be null");
        return user.addToWantedProducts(product);
    }

    @Override
    public List<User> subscribedUsers(Product product) {
        Objects.requireNonNull(product, "Product can`t be null");
        return stock.getUsers().stream()
                .filter(user -> user.getWantedProducts().contains(product))
                .collect(Collectors.toList());
    }
}
