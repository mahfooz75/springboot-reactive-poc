package com.selftech.springbootreactivepoc.service;

import com.selftech.springbootreactivepoc.dao.CustomerDao;
import com.selftech.springbootreactivepoc.dto.Customer;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class CustomerService {

    private CustomerDao customerDao;

    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<Customer> loadCustomers() {
        long start = System.currentTimeMillis();
        List<Customer> customers = customerDao.getCustomers();
        long end = System.currentTimeMillis();
        System.out.println("Total Execution Time: " + (end - start));
        return customers;
    }

    public Flux<Customer> loadCustomersStream() {
        long start = System.currentTimeMillis();
        Flux<Customer> customers = customerDao.getCustomersStream();
        long end = System.currentTimeMillis();
        System.out.println("Total Execution Time: " + (end - start));
        return customers;
    }
}
