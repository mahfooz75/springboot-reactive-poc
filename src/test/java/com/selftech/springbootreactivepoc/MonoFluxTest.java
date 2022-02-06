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

    @Test
    public void testMonoException(){
        // Here monoString is our Publisher
        Mono<?> monoString = Mono.just("selftect")
                .then(Mono.error(new RuntimeException("Error Occured")))
                .log();
        // Calling subscribe method on publisher
        monoString.subscribe((x)-> System.out.println(x),
                (e)-> System.out.println(e.getMessage()));
    }
}
