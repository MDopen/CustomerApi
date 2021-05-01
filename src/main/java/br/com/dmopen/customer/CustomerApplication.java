package br.com.dmopen.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.scheduler.ReactorBlockHoundIntegration;

@SpringBootApplication
public class CustomerApplication {

    static {
    }
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

}
