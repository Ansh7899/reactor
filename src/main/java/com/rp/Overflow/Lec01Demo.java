package com.rp.Overflow;

import com.rp.utils.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

//since no subscribeOn is used main thread will be responsible for pushing items
//but as publishOn is used so beyond that thread-pool will change

//we can see that even before 1 item is received the publisher emits several items
//and java has to store items in memory (default behaviour) which can cause OOM errors

public class Lec01Demo {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
            for (int i = 0; i < 500; i++) {
                fluxSink.next(i);
                System.out.println("emitted: " + i);
            }
            fluxSink.complete();
        })
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> {
                    Util.sleepMillis(10);
                })
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }
}
