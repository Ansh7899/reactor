package com.rp.ThreadingAndSchedulers;

import com.rp.utils.Util;
import reactor.core.publisher.Flux;

public class Lec01ThreadDemo {
    public static void main(String[] args) {
        Flux<Object> flux = Flux.create(fluxSink -> {
                    printThreadName("create");
                    fluxSink.next(1);
                })
                .doOnNext(i -> printThreadName("next" + i));

        Runnable runnable = () -> flux.subscribe(v -> printThreadName("sub" + v));

        for(int i=0;i<2;i++){
            new Thread(runnable).start();
        }
        Util.sleepSeconds(5);
    }

    public static void printThreadName(String text){
        System.out.println(text + "\t\t: current thread: " + Thread.currentThread().getName());
    }
}