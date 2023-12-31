package com.rp.AdvancedFlux;

import com.rp.utils.Util;
import reactor.core.publisher.Flux;

// take operator cancels the subscription after given items are emitted
public class Lec03TakeOperator {
    public static void main(String[] args) {

        Flux.range(1, 10)
                .log()
                .take(4)
                .log()
                .subscribe(Util.subscriber());
    }
}
