package com.rp.AdvancedFlux;

import com.rp.AdvancedFlux.helper.NameProducer;
import com.rp.utils.Util;
import reactor.core.publisher.Flux;

public class Lec02FluxCreateRefactor {
    public static void main(String[] args) {
        NameProducer nameProducer = new NameProducer();

        Flux.create(nameProducer).subscribe(Util.subscriber());

        Runnable runnable = nameProducer::produce;

        for (int i = 0; i < 5; i++) {
            new Thread(runnable).start();
        }

        Util.sleepSeconds(2);

    }
}
