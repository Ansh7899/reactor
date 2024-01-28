package com.rp.ThreadingAndSchedulers;

import com.rp.utils.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec02SubscribeOnDemo {

//    the subscribeOn closest to the publisher will always take the precedence

    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(fluxSink -> {
                    printThreadName("create");
                    fluxSink.next(1);
                })
                .subscribeOn(Schedulers.newParallel("alujsdgb"))
                .doOnNext(i -> printThreadName("next" + i));

        Runnable runnable = () -> flux
                .doFirst(() -> System.out.println("executing on first"))
                .subscribeOn(Schedulers.boundedElastic())
                .doFirst(() -> System.out.println("executing second first"))
                .subscribe(v -> printThreadName("sub" + v));

        for (int i = 0; i < 2; i++) {
            new Thread(runnable).start();
        }
        Util.sleepSeconds(5);
    }

    public static void printThreadName(String text){
        System.out.println(text + "\t\t: current thread: " + Thread.currentThread().getName());
    }
}
