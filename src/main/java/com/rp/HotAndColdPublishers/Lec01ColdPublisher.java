package com.rp.HotAndColdPublishers;

import com.rp.utils.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;
//here we can see how cold publisher works
//ash and mike both want to watch the same movie
//the publisher will emit the same data as and when a subscriber
//comes and request for data
public class Lec01ColdPublisher {
    public static void main(String[] args) {
        Flux<String> stringFlux = Flux.fromStream(() -> getMovie())
                        .delayElements(Duration.ofSeconds(2));

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
                "scene5"
        );
    }
}
