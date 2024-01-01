package com.rp.Operators;

import com.rp.utils.Util;
import reactor.core.publisher.Flux;

public class Lec03LimitRate {
    public static void main(String[] args) {
//        this will request for 10 items
//        once 75% of items are consumed
//        it will request for more from publisher
        Flux.range(1,100)
                .log()
                .limitRate(10)
                .subscribe(Util.subscriber());

//        we can modify the 75% as below
//        also if we keep both values same, it will act as 75%
//        if you want to drain 100% data, use 0 as second parameter
        Flux.range(1,100)
                .log()
                .limitRate(10, 50)
                .subscribe(Util.subscriber());


    }
}
