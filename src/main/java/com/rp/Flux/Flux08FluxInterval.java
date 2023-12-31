package com.rp.Flux;

import com.rp.Flux.helper.NameGenerator;
import com.rp.utils.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;


// how to emit items periodically
public class Flux08FluxInterval {
    public static void main(String[] args) {


        Flux.interval(Duration.ofSeconds(1))
                .subscribe(
                Util.onNext()
        );

        Util.sleepSeconds(6);
    }
}
