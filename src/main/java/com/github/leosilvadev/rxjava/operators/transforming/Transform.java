package com.github.leosilvadev.rxjava.operators.transforming;

import io.reactivex.Single;

public class Transform {

    public static void main(String[] args) {

        Single.just("Leonardo")
            .flatMap(name -> fetchUser(name))
            .subscribe(user -> {
                System.out.println(user);
            });

    }

    public static Single<User> fetchUser(String name) {
        return Single.defer(() -> Single.just(new User(name, 30)));
    }

    public static class User {
        String name;
        Integer age;

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }


    }
}
