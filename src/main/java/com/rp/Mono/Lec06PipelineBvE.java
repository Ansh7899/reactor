package com.rp.Mono;

import com.rp.utils.Util;
import reactor.core.publisher.Mono;

public class Lec06PipelineBvE {
    public static void main(String[] args) {


        getUserName();
        getUserName().subscribe(
                Util.onNext()
        );
        getUserName();

    }

    private static Mono<String> getUserName(){
        System.out.println("generating a name: ");
        return Mono.fromSupplier(() -> {
            System.out.println("inside pipeline");
            Util.sleepSeconds(4);
            return Util.faker().name().fullName();
        }).map(String::toLowerCase);
    }
}
