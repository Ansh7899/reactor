package com.rp.Mono;

import reactor.core.publisher.Mono;

import static com.rp.utils.Util.*;

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
                onNext(),
                onError(),
                onComplete()
        );
    }
}
