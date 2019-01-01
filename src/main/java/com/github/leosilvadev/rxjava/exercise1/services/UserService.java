package com.github.leosilvadev.rxjava.exercise1.services;

import com.github.leosilvadev.rxjava.exercise1.Delay;
import com.github.leosilvadev.rxjava.exercise1.domains.User;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.function.Consumer;

public class UserService {

    private final LinkedBlockingDeque<User> users;

    public UserService() {
        this.users = new LinkedBlockingDeque<>();
        users.add(new User(1L, "admin@admin.com", "root"));
    }

    public void findUser(final String email, final Consumer<User> callback) {
        Delay.run(1000L, () -> {
            System.out.println(String.format("Searching for user by email %s", email));
            users.stream().filter(u -> email.equals(u.getEmail()))
                    .findFirst()
                    .ifPresent(callback);
        });
    }

}
