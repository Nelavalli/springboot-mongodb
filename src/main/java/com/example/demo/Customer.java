package com.example.demo;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;

@Slf4j
@Data
@Builder
public class Customer {

    @Id
    private String id;

    private String firstName;
    private String lastName;
}
