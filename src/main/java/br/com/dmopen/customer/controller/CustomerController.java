package br.com.dmopen.customer.controller;

import br.com.dmopen.customer.model.Customer;
import br.com.dmopen.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> findAll(){
        return ResponseEntity.ok(this.customerService.findAll());
    }

    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody Customer customer){
        return ResponseEntity.ok(this.customerService.create(customer));
    }


    @GetMapping("/{customerUuid}")
    public ResponseEntity<Customer> findById(
            @PathVariable String customerUuid){
        return ResponseEntity.ok(this.customerService.findByUuid(customerUuid));
    }

    @PostMapping("/{customerUuid}")
    public ResponseEntity<Customer> update(
            @PathVariable String customerUuid,
            @RequestBody Customer customer){
        return ResponseEntity.ok(this.customerService.update(customerUuid, customer));
    }
}
