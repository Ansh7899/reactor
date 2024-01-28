package com.rp.ThreadingAndSchedulers;

import com.rp.utils.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec04PublishOn {
    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(fluxSink -> {
                    printThreadName("create");
                    for (int i = 0; i < 4; i++) {
                        fluxSink.next(i);
//                        Util.sleepSeconds(1);
                    }
                    fluxSink.complete();
                })
                .doOnNext(i -> printThreadName("next" + i));


        flux
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> System.out.println("next" + i))
                .subscribe(v -> printThreadName("sub" + v));

        Util.sleepSeconds(5);
    }

    public static void printThreadName(String text){
        System.out.println(text + "\t\t: current thread: " + Thread.currentThread().getName());
    }
}
