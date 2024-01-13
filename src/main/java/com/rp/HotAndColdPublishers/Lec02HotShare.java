package com.rp.HotAndColdPublishers;

import com.rp.utils.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

//share function is used to turn a cold publisher into a
//hot publisher.
//Hot publishers basically don't emit data for specific consumers
//the subscriber will receive only that data which is emitted after
//their subscription

public class Lec02HotShare {
    public static void main(String[] args) {
        Flux<String> stringFlux = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(2))
                .share();

        stringFlux.subscribe(Util.subscriber("ash"));

        Util.sleepSeconds(5);

        stringFlux.subscribe(Util.subscriber("kevin"));

        Util.sleepSeconds(60);
    }

    public static Stream<String> getMovie(){
        System.out.println("got a movie streaming request");
        return Stream.of(
                "scene1",
                "scene2",
                "scene3",
                "scene4",
                "scene5",
                "scene6",
                "scene7",
                "scene8"
        );
    }
}
