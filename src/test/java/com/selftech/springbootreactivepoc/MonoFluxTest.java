package com.selftech.springbootreactivepoc;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    public void testMono(){
        // Here monoString is our Publisher
        Mono<String> monoString = Mono.just("selftect");
        // Calling subscribe method on publisher
        monoString.subscribe((x)-> System.out.println(x));

        // Here name is our Publisher, using log method to print all intermediate steps involved in reactive
        Mono<String> name = Mono.just("Mahfooz").log();
        name.subscribe(System.out::println);
    }
}
