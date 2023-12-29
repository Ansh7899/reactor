package com.rp.utils;

import com.github.javafaker.Faker;

import java.util.function.Consumer;

public class Util {

    //Faker Instance to generate data
    private static final Faker FAKER = Faker.instance();

    //extracting behaviour of onNext()
    public static Consumer<Object> onNext() {
            return o -> System.out.println("Received item : " + o);
    }

    //extracting behaviour of onError()
    public static Consumer<Throwable> onError() {
        return e -> System.out.println("Error message : " + e.getMessage());
    }

    //extracting behaviour of onComplete()
    public static Runnable onComplete() {
        return () -> System.out.println("COMPLETED");
    }

    public static Faker faker() {
        return FAKER;
    }
}
