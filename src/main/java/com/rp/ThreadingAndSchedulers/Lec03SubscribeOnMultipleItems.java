package com.rp.ThreadingAndSchedulers;

import com.rp.utils.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

//even if we have multiple subscribers
//they will behave individually as their own separate entities
public class Lec03SubscribeOnMultipleItems {
    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(fluxSink -> {
                    printThreadName("create");
                    for (int i = 0; i < 4; i++) {
                        fluxSink.next(i);
                        Util.sleepSeconds(1);
                    }
                    fluxSink.complete();
                })
                .doOnNext(i -> printThreadName("next" + i));

        flux
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(v -> printThreadName("sub" + v));

        flux
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(v -> printThreadName("sub" + v));

        Util.sleepSeconds(5);
    }

    public static void printThreadName(String text){
        System.out.println(text + "\t\t: current thread: " + Thread.currentThread().getName());
    }
}
