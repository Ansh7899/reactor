package com.rp.sec02;

import com.rp.utils.Util;
import reactor.core.publisher.Flux;

public class Lec02FluxWithMutipleSubscribers {
    public static void main(String[] args) {
        Flux<Integer>flux = Flux.just(1,3,4,3,5,5,2,4567,8,4,2);

        Flux<Integer> evenFlux = flux.filter(i -> i%2==0);

        flux.subscribe(
                Util.onNext()
        );

        evenFlux.subscribe(
                Util.onNext()
        );
    }
}
