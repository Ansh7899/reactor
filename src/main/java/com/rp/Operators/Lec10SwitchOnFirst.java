package com.rp.Operators;

import com.rp.Operators.helper.Person;
import com.rp.utils.Util;
import reactor.core.publisher.Flux;

import java.util.function.Function;

//switchOnFirst helps in taking decisions based on first emitted item
public class Lec10SwitchOnFirst {

    public static void main(String[] args) {

        getPerson()
                .switchOnFirst((signal, flux) -> {
                    return signal.isOnNext() && signal.get().getAge() > 18 ? flux : applyFilterMap().apply(flux);
                })
                .subscribe(Util.subscriber());
    }

    public static Flux<Person> getPerson() {
        return Flux.range(1, 10)
                .map(i -> new Person());
    }

    public static Function<Flux<Person>, Flux<Person>> applyFilterMap(){
        return flux -> flux
                .filter(p -> p.getAge() > 10)
                .doOnNext(p -> p.setName(p.getName().toUpperCase()))
                .doOnDiscard(Person.class, p -> System.out.println("Not allowing : " + p));
    }
}
