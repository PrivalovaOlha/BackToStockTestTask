package com.example.service.impl;

import com.example.entity.Product;
import com.example.entity.ProductCategory;
import com.example.entity.User;
import com.example.service.NotificationService;
import com.example.service.UserService;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class NotificationServiceImpl implements NotificationService {
    private final UserService userService = new UserServiceImpl();

    @Override
    public void notifyUserByProduct(Product product) {
        Objects.requireNonNull(product, "Product can`t be null");
        calculatePriorityForNotification(product)
                .forEach(u -> System.out.println("Sending email to " + u.getName() + "..."));

    }

    private List<User> calculatePriorityForNotification(Product product) {
        List<User> fifoNotificationByPriority = new LinkedList<>();
        userService.subscribedUsers(product).stream()
                .sorted(Comparator.comparing(User::isPremium)
                        .thenComparing(user -> user.getAge() > 70 && product.getCategory() == ProductCategory.MEDICAL)
                        .thenComparing(user -> user.getAge() > 70).reversed())
                .forEach(fifoNotificationByPriority::add);

        return fifoNotificationByPriority;
    }
}
