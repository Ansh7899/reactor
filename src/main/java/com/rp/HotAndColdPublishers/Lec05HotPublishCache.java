package com.rp.HotAndColdPublishers;

import com.rp.utils.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

//cache will basically keep a history of some items and as soon as a new publisher joins
//it will give them those cached items.
public class Lec05HotPublishCache {
//cache = publish().replay()

    public static void main(String[] args) {
        Flux<String> stringFlux = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(1))
                .cache();

        Util.sleepSeconds(2);

        stringFlux.subscribe(Util.subscriber("ash"));

        Util.sleepSeconds(10);

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
