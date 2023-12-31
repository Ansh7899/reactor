package com.rp.Flux;

import com.rp.utils.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//creating flux from another publisher
public class Lec08FluxFromMono {
    public static void main(String[] args) {
        Mono<String> mono = Mono.empty();

        Flux<String> flux = Flux.from(mono);

        flux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
//creating mono from flux
        Flux.range(1,10)
                .filter(i -> i>6)
                .next()
                .subscribe(Util.onNext(), Util.onError() , Util.onComplete());

//        if we change position of filter, it will act as empty
//        as first item we get is 1 which is not greater than 3
        Flux.range(1,10)
                .next()
                .filter(i -> i>6)
                .subscribe(Util.onNext(), Util.onError() , Util.onComplete());
    }
}
