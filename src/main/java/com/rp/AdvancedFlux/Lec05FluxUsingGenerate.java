package com.rp.AdvancedFlux;

import com.rp.utils.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxUsingGenerate {
    public static void main(String[] args) {

//       generate will run the pipeline infinte times
//       to see that comment the line-13
        Flux.generate(synchronousSink -> {
            synchronousSink.next(Util.faker().ancient().titan());
        })
                .take(3)
                .subscribe(Util.subscriber());

//        Using synchronousSink run the publisher until titan name comes with Theia
        Flux.generate(synchronousSink -> {
            String titan = Util.faker().ancient().titan();
            synchronousSink.next(titan);
            if (titan.equalsIgnoreCase("theia"))
                synchronousSink.complete();
        }).subscribe(Util.subscriber());

//        if theia comes exit, but you can emit only 12 items at max
        Flux.generate(
                () -> 1,
                (counter, sink) -> {
                    String titanName = Util.faker().ancient().titan();
                    sink.next(titanName);
                    if(counter>=10 || titanName.equalsIgnoreCase("theia"))
                        sink.complete();
                    return counter + 1;

        }).subscribe(Util.subscriber());
    }
}
