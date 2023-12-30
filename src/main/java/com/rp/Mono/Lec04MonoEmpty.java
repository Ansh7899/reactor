package com.rp.Mono;

import com.rp.utils.Util;
import reactor.core.publisher.Mono;

// demonstrating the mono.empty() behaviour
public class Lec04MonoEmpty {
    public static void main(String[] args) {

        userInfo(2).subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );

    }

    private static Mono<String> userInfo(int id){

        if(id==1){
            return Mono.just(Util.faker().name().firstName());
        }else if(id == 2){
            return Mono.empty();
        } else
            return Mono.error(new RuntimeException("not found"));

    }
}
