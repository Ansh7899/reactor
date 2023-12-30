package com.rp.sec01;

import com.rp.utils.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;

import static com.rp.utils.Util.onNext;

public class Lec05MonoFromCallable {
    public static void main(String[] args) {


        Mono<String> mono = Mono.fromSupplier(() -> getUserName());

        mono.subscribe(
                onNext()
        );

        Callable<String> stringCallable = () -> getUserName();
        Mono.fromCallable(stringCallable).subscribe(
                onNext()
        );

    }

    private static String getUserName(){
        System.out.println("generating a name: ");
        return Util.faker().name().fullName();
    }
}
