package com.rp.Flux;

import com.rp.utils.Util;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;
//custom subscriber
public class Lec06Subscription {
    public static void main(String[] args) {

        AtomicReference<Subscription> atomicReference = new AtomicReference<>();
        Flux<Integer> range = Flux.range(1, 20);

        range
                .log()
                .subscribeWith(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                System.out.println("subscribed" + subscription);
                atomicReference.set(subscription);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext: " + integer);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError" + throwable.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("completed");
            }
        });

        atomicReference.get().request(3);
        Util.sleepSeconds(3);
        atomicReference.get().request(4);
        Util.sleepSeconds(3);
        atomicReference.get().cancel();


    }
}
