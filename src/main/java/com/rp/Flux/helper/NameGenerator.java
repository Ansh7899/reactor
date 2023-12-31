package com.rp.Flux.helper;

import com.rp.utils.Util;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {
    public static List<String> getNames(int count){
        List<String> list = new ArrayList<String>();
        for(int i=0; i < count; i++){
            list.add(getName());
        }
        return list;
    }

    public static Flux<String> getNames2(int count) {
        return Flux.range(0,count)
                .map(i -> getName());

    }

    private static String getName(){
        Util.sleepSeconds(1);
        return Util.faker().name().fullName();
    }
}
