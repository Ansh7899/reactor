package com.rp.sec02;

import com.rp.utils.Util;
import reactor.core.publisher.Flux;

// creating flux from range
public class Lec05FluxFromRange {
    public static void main(String[] args) {

        Flux.range(3,100).subscribe(
                Util.onNext()
        );
    }
}
