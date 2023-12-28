package com.rp.sec01;

import reactor.core.publisher.Mono;

// Mono subscribe, oncomplete and on error

public class Lec03MonoSubs {
    public static void main(String[] args) {


// on error
//        Mono<String> mono = Mono.just("ANSHDSYGFV")
//                                .map(s -> s.length())
//                                .map(l -> String.valueOf(l/0));

// oncomplete
        Mono<String> mono = Mono.just("ANSHDSYGFV")
                .map(s -> s.toLowerCase());

        mono.subscribe(
                item -> System.out.println(item),
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("completed")
        );
    }
}
