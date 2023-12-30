package com.rp.Mono;
import reactor.core.publisher.Mono;

// demonstrating basic publisher and subscriber relation
public class Lec02MonoJust {
   public static void main(String[] args) {

      //publisher
      Mono<Integer> mono = Mono.just(1);

      mono.subscribe(integer -> System.out.println("recieved an integer: " + integer));
   }
}
