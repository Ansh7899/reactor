package com.rp.AdvancedFlux;

import com.rp.utils.Util;
import reactor.core.publisher.Flux;

public class Lec04FixFluxCreateIssue {
    public static void main(String[] args) {
//        it will keep on emitting items even when subscriber wants only first 3
        Flux.create(fluxSink -> {
            while(true){
                String countryName = Util.faker().country().name();
                System.out.println("emitting: " + countryName);
                fluxSink.next(countryName);
                if(countryName.equalsIgnoreCase("poland"))
                    break;
            }
            fluxSink.complete();
        })
                .take(3)
                .subscribe(Util.subscriber());

//    to prevent this from happening we can use isCancelled()

        Flux.create(fluxSink -> {
            while(true){
                String countryName = Util.faker().country().name();
                fluxSink.next(countryName);
                if(!countryName.equalsIgnoreCase("poland") && !fluxSink.isCancelled())
                    break;
            }
            fluxSink.complete();
        }).subscribe(Util.subscriber());
    }


}
