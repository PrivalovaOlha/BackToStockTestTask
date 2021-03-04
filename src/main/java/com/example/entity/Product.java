package com.example.entity;

import java.util.Objects;


public class Product {

    private final String id;
    private final ProductCategory category;
    private final String name;

    public Product(String id, ProductCategory category, String name) {
        this.id = id;
        this.category = category;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                category == product.category &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, name);
    }
}
