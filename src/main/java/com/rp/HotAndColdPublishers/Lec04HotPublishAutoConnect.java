package com.rp.HotAndColdPublishers;

import com.rp.utils.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

//using autoConnect method will basically make the publisher hot-hot one
//when kevin will join till then the data will be exhausted.


//also when min subs is set to 0 the publisher won't wait for any subscriber to join and will start emitting items
//even if no subscriber is present
public class Lec04HotPublishAutoConnect {
        public static void main(String[] args) {
            Flux<String> stringFlux = Flux.fromStream(() -> getMovie())
                    .delayElements(Duration.ofSeconds(1))
                            .publish()
                                    .autoConnect(0);

            Util.sleepSeconds(3);

            stringFlux
                    .subscribe(Util.subscriber("ash"));

            Util.sleepSeconds(10);

            stringFlux
                    .subscribe(Util.subscriber("kevin"));

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
