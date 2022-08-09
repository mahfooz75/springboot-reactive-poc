package com.selftech.springbootreactivepoc.dao;

import com.selftech.springbootreactivepoc.dto.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDao {

    private static void sleepExecution(int i){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Customer> getCustomers(){
        return IntStream.rangeClosed(1,50)
                .peek(CustomerDao::sleepExecution)
                .peek(i-> System.out.println("Processing count: "+i))
                .mapToObj(i->new Customer(i,"customer-"+i))
                .collect(Collectors.toList());
    }

    public Flux<Customer> getCustomersStream(){
        return Flux.range(1,50)
                .delayElements(Duration.ofMillis(500))
                .doOnNext(i-> System.out.println("Processing count in stream flow: "+i))
                .map(i->new Customer(i,"customer-"+i));
    }
}
