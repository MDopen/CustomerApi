package br.com.dmopen.customer.controller;

import br.com.dmopen.customer.model.Customer;
import br.com.dmopen.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public Flux<Customer> listAll(){
        return this.customerService.findAll();
    }

    @PostMapping
    public Mono<Customer> create(@RequestBody Customer customer){
        return this.customerService.create(customer);
    }


    @GetMapping("/{customerUuid}")
    public Mono<Customer> findById(
            @PathVariable String customerUuid){
        return this.customerService.findByUuid(customerUuid);
    }

    @PostMapping("/{customerUuid}")
    public Mono<Customer> update(
            @PathVariable String customerUuid,
            @RequestBody Customer customer){
        return this.customerService.update(customerUuid, customer);
    }
}
