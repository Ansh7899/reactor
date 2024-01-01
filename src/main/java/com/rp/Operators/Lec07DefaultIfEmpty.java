package com.rp.Operators;

import com.rp.utils.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

//used to provide some default value if empty item comes

public class Lec07DefaultIfEmpty {
    public static void main(String[] args) {

        getNumbers()
                .filter(i -> i>10)
                .defaultIfEmpty(-1)
                .subscribe(Util.subscriber());


    }

    public static Flux<Integer> getNumbers (){
        return Flux.range(1, 10);

    }
}
