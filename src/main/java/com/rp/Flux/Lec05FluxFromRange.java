package com.rp.Flux;

import com.rp.utils.Util;
import reactor.core.publisher.Flux;

// creating flux from range with logging for better debugging
public class Lec05FluxFromRange {
    public static void main(String[] args) {

        Flux.range(3,100)
                .log()
                .map(i -> Util.faker().name().firstName())
                .subscribe(
                Util.onNext()
        );
    }
}
