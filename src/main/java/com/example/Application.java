package com.example;

import com.example.db.Stock;
import com.example.entity.Product;
import com.example.entity.ProductCategory;
import com.example.entity.User;
import com.example.service.ProductService;
import com.example.service.UserService;
import com.example.service.impl.ProductServiceImpl;
import com.example.service.impl.UserServiceImpl;

import java.util.Map;
import java.util.Set;

public class Application {

    private static final ProductService productService = new ProductServiceImpl();
    private static final UserService userService = new UserServiceImpl();
    private static final Stock stock = Stock.getInstance();

    public static void main(String[] args) {
        init();

        productService.fillUpProduct(new Product("1", ProductCategory.MEDICAL, "painkiller"), 1L);
        System.out.println("********");
        productService.fillUpProduct(new Product("3", ProductCategory.BOOKS, "fiction"), 1L);
    }

    private static void init() {
        Map<Product, Long> products = stock.getProducts();
        Product painkiller = new Product("1", ProductCategory.MEDICAL, "painkiller");
        Product antipyretic = new Product("2", ProductCategory.MEDICAL, "antipyretic");
        Product fiction = new Product("3", ProductCategory.BOOKS, "fiction");
        Product phone = new Product("4", ProductCategory.DIGITAL, "phone");
        products.put(painkiller, 0L);
        products.put(antipyretic, 0L);
        products.put(fiction, 0L);
        products.put(phone, 0L);

        Set<User> users = stock.getUsers();
        User premiumMan = new User(1L, "Man Premium", true, 25);
        User oldMan = new User(2L, "Old man", false, 71);
        User ivan = new User(4L, "Ivan Ivanov", false, 25);
        User karl = new User(3L, "Karl Karlov", false, 12);
        users.add(premiumMan);
        users.add(oldMan);
        users.add(ivan);
        users.add(karl);

        userService.subscribe(karl, painkiller);
        userService.subscribe(premiumMan, painkiller);
        userService.subscribe(premiumMan, fiction);
        userService.subscribe(oldMan, painkiller);
        userService.subscribe(ivan, painkiller);
        userService.subscribe(ivan, fiction);
    }
}
