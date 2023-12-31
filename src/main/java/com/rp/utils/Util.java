package com.rp.utils;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;

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

    public static void sleepSeconds(int millis){
        try {
            Thread.sleep(millis * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void sleepMillis(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Subscriber<Object> subscriber() {
        return new DefaultSubscriber();
    }

    public static Subscriber<Object> subscriberWithName(String name) {
        return new DefaultSubscriber(name);
    }
}
