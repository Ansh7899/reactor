package com.rp.Flux;

import com.rp.utils.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class Lec03FluxFromArrayList {
    public static void main(String[] args) {

//        for strings
        List<String> list = Arrays.asList("a", "v", "dsfv", "jkiefdnv");

        Flux.fromIterable(list)
                .subscribe(
                        Util.onNext()
                );
//        for Integers
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 45, 5);

        Flux.fromIterable(integerList)
                .filter(i -> i%2 ==0)
                .subscribe(
                        Util.onNext()
                );

        
    }
}
