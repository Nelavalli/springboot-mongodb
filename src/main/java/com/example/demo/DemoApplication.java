package com.example.demo;

import java.util.Arrays;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@Slf4j
@AllArgsConstructor
@EnableMongoRepositories
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    private CustomerRepository customerRepository;

    @Override
    public void run(String[] args) {
        List<Customer> customers = Arrays.asList(
            Customer.builder().firstName("Rama").lastName("Nelavalli").build(),
            Customer.builder().firstName("Anusha").lastName("Nelavalli").build(),
            Customer.builder().firstName("Balakrishna").lastName("Nelavalli").build()
        );
        saveToMongoDB(customers);
        retrieveAllCustomers().stream().forEach(System.out::println);
        removeFromMongoDB(retrieveAllCustomers());
    }

    public void saveToMongoDB(List<Customer> customers) {
        customers.stream().forEach(c -> saveToMonoDB(c));
    }

    public void saveToMonoDB(Customer customer) {
        customerRepository.save(customer);
    }

    public List<Customer> retrieveAllCustomers() {
        return customerRepository.findAll();
    }

    public void removeFromMongoDB(List<Customer> customers) {
        customers.stream().forEach(c -> removeFromMongoDB(c));
    }

    public void removeFromMongoDB(Customer c) {
        customerRepository.delete(c);
    }
}
