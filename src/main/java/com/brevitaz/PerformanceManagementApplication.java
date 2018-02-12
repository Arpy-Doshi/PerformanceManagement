package com.brevitaz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.brevitaz")
public class PerformanceManagementApplication
{
    public static void main(String[] args) {
        SpringApplication.run(PerformanceManagementApplication.class, args);
    }
}
