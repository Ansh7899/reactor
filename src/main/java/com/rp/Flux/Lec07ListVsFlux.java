package com.rp.Flux;

import com.rp.Flux.helper.NameGenerator;
import com.rp.utils.Util;

//List vs flux difference
public class Lec07ListVsFlux {
    public static void main(String[] args) {
//        to display list
//        System.out.println(NameGenerator.getNames(5));

//        to display how flux works
        NameGenerator.getNames2(3).subscribe(
                Util.onNext()
        );
    }
}
