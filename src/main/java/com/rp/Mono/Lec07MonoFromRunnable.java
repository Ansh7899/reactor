package com.rp.Mono;

import com.rp.utils.Util;
import reactor.core.publisher.Mono;

public class Lec07MonoFromRunnable {
    public static void main(String[] args) {

        Mono.fromRunnable(timeTakingProcess()).subscribe(
                Util.onNext(),
                Util.onError(),
                () -> {
                    System.out.println("Process completed ... sending emails...");
                }
        );

    }
    private static Runnable timeTakingProcess() {
        return () -> {

            Util.sleepSeconds(4);
            System.out.println("operation completed");

        };
    }

}
