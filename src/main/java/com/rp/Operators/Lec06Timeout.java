package com.rp.Operators;

import com.rp.utils.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

//here in main method the subscriber waits for
//only 2 seconds else throws an error
//though the publisher is emitting items at 5 seconds
//so we created a fallback method that can provide the value in that case
public class Lec06Timeout {

    public static void main(String[] args) {

        getNumbers()
                .log()
                .timeout(Duration.ofSeconds(2), fallback())
                .subscribe(Util.subscriber());
    }

    public static Flux<Integer> getNumbers (){
        return Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(5));

    }

    public static Flux<Integer> fallback (){
        return Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(1));

    }
}
