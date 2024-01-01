package com.rp.Operators;

import com.rp.utils.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec04Delay {
    public static void main(String[] args) {


        System.setProperty("reactor.bufferSize.x", "9");

//        delayElements implements limitRate in itself
//        it will request for 9 elements (default 32)
//        and then slowly emit them to the subscriber
        
        Flux.range(1, 100)
                .log()
                .delayElements(Duration.ofSeconds(1))
                .subscribe(Util.subscriber());


        Util.sleepSeconds(60);
    }
}
