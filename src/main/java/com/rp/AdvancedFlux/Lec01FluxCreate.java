package com.rp.AdvancedFlux;

import com.rp.AdvancedFlux.helper.NameProducer;
import com.rp.utils.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxCreate {
    public static void main(String[] args) {
//        when code logic is implicitly written in publisher
        Flux.create(fluxSink -> {
           while(true){
               String countryName = Util.faker().country().name();
               fluxSink.next(countryName);
               if(countryName.equalsIgnoreCase("poland"))
                   break;
           }
           fluxSink.complete();
        }).subscribe(Util.subscriber());

//        taking help from NameProducer class
        NameProducer nameProducer = new NameProducer();

        Flux.create(nameProducer).subscribe(Util.subscriber());

        nameProducer.produce();


    }
}
