package com.rp.Operators;


import com.rp.utils.Util;
import reactor.core.publisher.Flux;

//handle = filter + map
public class Lec01Handle {
    public static void main(String[] args) {

        // handle = filter + map
        Flux.range(1, 20)
                .handle((integer, synchronousSink) -> {
                    if(integer == 7)
                        synchronousSink.complete();
                    else
                        synchronousSink.next(integer);
                })
                .subscribe(Util.subscriber());

    Flux.generate(synchronousSink -> synchronousSink.next(Util.faker().country().name()))
                .map(Object::toString)
                .handle((countryName, synchronousSink) -> {
                    synchronousSink.next(countryName); //map
                    if(countryName.equalsIgnoreCase("india")) //filter
                        synchronousSink.complete();
                })
                .subscribe(Util.subscriber());
    }
}
