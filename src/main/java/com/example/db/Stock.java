package com.example.db;

import com.example.entity.Product;
import com.example.entity.User;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Stock {

    private static Stock instance;

    private Map<Product, Long> products;
    private Set<User> users;

    private Stock(Map<Product, Long> products, Set<User> users) {
        this.products = products;
        this.users = users;
    }

    public static Stock getInstance() {
        if (instance == null) {
            instance = new Stock(new HashMap<Product, Long>(), new HashSet<User>());
        }
        return instance;
    }

    public Map<Product, Long> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Long> products) {
        this.products = products;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
