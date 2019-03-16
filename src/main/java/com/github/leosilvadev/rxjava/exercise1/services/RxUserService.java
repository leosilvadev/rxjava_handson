package com.github.leosilvadev.rxjava.exercise1.services;

import com.github.leosilvadev.rxjava.exercise1.domains.User;
import io.reactivex.Maybe;
import io.reactivex.Observable;

import java.util.Optional;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class RxUserService {

    private final LinkedBlockingDeque<User> users;

    public RxUserService() {
        this.users = new LinkedBlockingDeque<>();
        this.users.add(new User(1L, "admin@admin.com", "root"));
    }

    public Maybe<User> findUser(final String email) {
        return Maybe.timer(1, TimeUnit.SECONDS)
                .flatMapObservable(i -> Observable.fromIterable(users))
                .filter(u -> email.equals(u.getEmail()))
                .firstElement();
    }

}
