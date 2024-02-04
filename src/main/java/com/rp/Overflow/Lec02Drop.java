package com.rp.Overflow;

import com.rp.utils.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;

//the dropped values will be added to the mocked DB as list in this
public class Lec02Drop {
    public static void main(String[] args) {

        System.setProperty("reactor.bufferSize.small", "16");
        List<Object> list = new ArrayList<>();

        Flux.create(fluxSink -> {
            for (int i = 0; i < 300; i++) {
                fluxSink.next(i);
                System.out.println("pushed : " + i);
                Util.sleepMillis(1);
            }
            fluxSink.complete();
        })
                .onBackpressureDrop(list::add)
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> {
                    Util.sleepMillis(10);
                })
                .subscribe(Util.subscriber());

        System.out.println(list);
        Util.sleepSeconds(10);
    }
}
