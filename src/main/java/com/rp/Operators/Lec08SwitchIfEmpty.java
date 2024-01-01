package com.rp.Operators;

import com.rp.utils.Util;
import reactor.core.publisher.Flux;

//You can provide a fallback method instead of a default constant value
//even if publisher publishes one item we won't invoke
//switchIfEmpty()
public class Lec08SwitchIfEmpty {
    public static void main(String[] args) {

        getNumbers()
                .filter(i -> i>10)
                .switchIfEmpty(fallback())
                .subscribe(Util.subscriber());
    }

    public static Flux<Integer> getNumbers (){
        return Flux.range(1, 10);

    }

    public static Flux<Integer> fallback (){
        return Flux.range(20, 10);

    }
}
