package com.github.leosilvadev.rxjava.why;

import com.github.javafaker.Faker;

import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Consumer;

public class InfiniteStream {

    private static final Timer timer = new Timer();

    public static void main(String[] args) {
        stream(character -> {
            String city = getCity();
            String dragon = getDragon();

            System.out.println(goTo(character, city));
            tryToKill(character, dragon, city, won -> {
                if (won) {
                    String lastCity = getCity();
                    String lastDragon = getDragon();
                    System.out.println(goTo(character, lastCity));
                    tryToKill(character, lastDragon, lastCity, wonAgain -> {
                        if (wonAgain) {
                            System.out.println(String.format("%s is the BEST one!\n\n", character));
                        } else {
                            System.out.println("Not so lucky that time... sorry!\n\n");
                        }
                    });
                } else {
                    System.out.println("Pfff... get out of here!\n\n");
                }
            });
        });
    }

    private static void stream(Consumer<String> consumer) {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                consumer.accept(getCharacter());
            }
        }, 1000, 5000);
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

    private static void tryToKill(String character,
                                    String enemy,
                                    String city,
                                    Consumer<Boolean> callback) {

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Boolean won = new Faker().random().nextBoolean();
                String result = won ? "WON" : "LOST";
                System.out.println(String.format("Arriving at %s, %s tried to kill %s and %s", city, character, enemy, result));
                callback.accept(won);
            }
        }, 2000);
    }
}
