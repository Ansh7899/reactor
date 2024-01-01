package com.rp.Operators;

import com.rp.utils.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec05OnError {
    public static void main(String[] args) {

//        here onError will return a default value but still
//        will cancel the subscription
        Flux.range(1, 10)
                .log()
                .map(i -> 10/(5 - i))
//                .onErrorReturn(-1)    used to return a default value but cancels subscription
//                .onErrorResume(e -> fallbackValue())    used to return a fallback method but cancels subscription
//                below method will accept error and cause of error but will continue the pipeline
                .onErrorContinue((err, obj) -> {
                    System.out.println("error: " + err.getMessage());
                    System.out.println("Caused by: " + obj);
                })
                .subscribe(Util.subscriber());

    }

    private static Mono<Integer> fallbackValue (){
        return Mono.fromSupplier(() -> Util.faker().random().nextInt(100, 200));
    }
}
