package com.microsoft.quantum.qlmsrequestservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class QlmsRequestServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(
                QlmsRequestServiceApplication.class, args);
    }
}