package com.rp.HotAndColdPublishers;

import com.rp.utils.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

//here only the stream will start once the minimum number of publishers subscribe to the publisher
public class Lec03HotPublish {
        public static void main(String[] args) {
            Flux<String> stringFlux = Flux.fromStream(() -> getMovie())
                    .delayElements(Duration.ofSeconds(2))
                    .publish()
                            .refCount(2);

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
