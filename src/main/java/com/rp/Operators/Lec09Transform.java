package com.rp.Operators;

import com.rp.Operators.helper.Person;
import com.rp.utils.Util;
import org.yaml.snakeyaml.DumperOptions;
import reactor.core.publisher.Flux;

import java.util.function.Function;

public class Lec09Transform {
    public static void main(String[] args) {


        getPerson()
                .transform(applyFilterMap())
                .subscribe(Util.subscriber());
    }

    public static Flux<Person> getPerson() {
        return Flux.range(1, 10)
                .map(i -> new Person());
    }


//    creating a custom filter which can be used with transform operator to filter out things
    public static Function<Flux<Person>, Flux<Person>> applyFilterMap(){
        return flux -> flux
                .filter(p -> p.getAge() > 10)
                .doOnNext(p -> p.setName(p.getName().toUpperCase()))
                .doOnDiscard(Person.class, p -> System.out.println("Not allowing : " + p));
    }
}
