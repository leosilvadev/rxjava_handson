package com.github.leosilvadev.rxjava.why;

import com.github.javafaker.Faker;
import io.reactivex.Flowable;
import io.reactivex.Single;
import org.apache.commons.lang3.tuple.Pair;
import java.util.concurrent.TimeUnit;

public class RxInfiniteStream {

    public static void main(String[] args) throws InterruptedException {
        stream().flatMapSingle(character -> {
            String city = getCity();
            String dragon = getDragon();
            System.out.println(goTo(character, city));
            return tryToKill(character, dragon, city).map(won -> Pair.of(character, won ? 1 : 0));

        }).flatMapSingle(pair -> {
            if (pair.getRight() == 0) {
                return Single.just(pair);
            }

            String character = pair.getLeft();
            String city = getCity();
            String dragon = getDragon();
            System.out.println(goTo(character, city));
            return tryToKill(character, dragon, city).map(won -> Pair.of(character, won ? 2 : 1));

        }).subscribe(pair -> {
            String character = pair.getLeft();
            if (pair.getRight() == 2) {
                System.out.println(String.format("%s is the BEST one!\n\n", character));

            } else if (pair.getRight() == 1) {
                System.out.println("Not so lucky that time... sorry!\n\n");

            } else {
                System.out.println("Pfff... get out of here!\n\n");

            }
        });

        Thread.sleep(50_000);
    }

    private static Flowable<String> stream() {
        return Flowable.interval(1, 5, TimeUnit.SECONDS)
                .map(i -> getCharacter());
    }

    private static String getCharacter() {
        Faker faker = new Faker();
        return faker.gameOfThrones().character();
    }

    private static String getDragon() {
        Faker faker = new Faker();
        return faker.gameOfThrones().dragon();
    }

    private static String getCity() {
        Faker faker = new Faker();
        return faker.gameOfThrones().city();
    }

    private static String goTo(String character, String city) {
        return String.format("%s go to %s", character, city);
    }

    private static Single<Boolean> tryToKill(String character,
                                    String enemy,
                                    String city) {

        return Single.timer(2, TimeUnit.SECONDS)
                .map(i -> {
                    Boolean won = new Faker().random().nextBoolean();
                    String result = won ? "WON" : "LOST";
                    System.out.println(String.format("Arriving at %s, %s tried to kill %s and %s", city, character, enemy, result));
                    return won;
                });
    }
}
