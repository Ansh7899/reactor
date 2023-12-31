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

    }
}
