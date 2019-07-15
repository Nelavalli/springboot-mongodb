package com.example.demo;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    List<Customer> customers;
    @Autowired
    DemoApplication demoApplication;

    @Test
    public void contextLoads() {
    }

    @Test
    public void saveToMongoDBTest() {
        givenCustomers();
        whenCustomerSavedToMongoDb();
        verifyCustomerSaved();
    }

    private void givenCustomers() {

        customers = Arrays.asList(
            Customer.builder().firstName("Rama").lastName("Nelavalli").build(),
            Customer.builder().firstName("Anusha").lastName("Nelavalli").build(),
            Customer.builder().firstName("Balakrishna").lastName("Nelavalli").build()
        );
        System.out.println(customers);

        customers.stream().forEach(c -> demoApplication.removeCustomerFromMongoDB(c.getFirstName(), c.getLastName()));

    }

    private void whenCustomerSavedToMongoDb() {
        demoApplication.saveToMongoDB(customers);
    }

    private void verifyCustomerSaved() {
        List<Customer> retrievedCustomers = demoApplication.retrieveAllCustomers();
        assertEquals(customers, retrievedCustomers);
    }
}
