package com.example.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User {

    private Long id;
    private String name;
    private boolean premium;
    private Integer age;
    private Set<Product> wantedProducts = new HashSet<>();

    public User(Long id, String name, boolean premium, Integer age) {
        this.id = id;
        this.name = name;
        this.premium = premium;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<Product> getWantedProducts() {
        return wantedProducts;
    }

    public void setWantedProducts(Set<Product> wantedProducts) {
        this.wantedProducts = wantedProducts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return premium == user.premium &&
                Objects.equals(id, user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(age, user.age) &&
                Objects.equals(wantedProducts, user.wantedProducts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, premium, age, wantedProducts);
    }

    public boolean addToWantedProducts(Product product) {
        return this.wantedProducts.add(product);
    }
}
