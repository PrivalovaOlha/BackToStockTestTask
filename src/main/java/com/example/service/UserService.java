package com.example.service;

import com.example.entity.Product;
import com.example.entity.User;

import java.util.List;

public interface UserService {

    boolean subscribe(User user, Product product);

    List<User> subscribedUsers(Product product);
}
