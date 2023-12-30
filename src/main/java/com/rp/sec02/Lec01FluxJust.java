package com.rp.sec02;

import com.rp.utils.Util;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//demo flux just
public class Lec01FluxJust {
    public static void main(String[] args) {

        List<Object> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        list.add(Util.faker().name().firstName());

        Flux<List<Object>> flux = Flux.just(list);

        flux.subscribe(Util.onNext());

    }
}
