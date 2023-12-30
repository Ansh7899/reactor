package com.rp.sec02;

import com.rp.utils.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

// flux from stream

public class Lec04FluxFromStream {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);

//        Stream<Integer> stream = integerList.stream();

//        since streams can't be reused it will throw error
//        Flux<Integer> flux = Flux.fromStream(stream);
//
//        since stream is created, same reference would be passed to the 2nd subscriber
//        Flux<Integer> flux = Flux.fromStream(() -> stream);

        //We need to create stream as part of supplier
        Flux<Integer> flux = Flux.fromStream(() -> integerList.stream());

        flux.subscribe(
                Util.onNext()
        );

        flux.subscribe(
                Util.onNext(),
                Util.onError()
        );

    }
}
