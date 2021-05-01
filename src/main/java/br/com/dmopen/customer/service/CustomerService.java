package br.com.dmopen.customer.service;

import br.com.dmopen.customer.model.Customer;
import br.com.dmopen.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository repository;

    public Flux<Customer> findAll(){
        return this.repository.findAll();
    }

    public Mono<Customer> findByUuid(String uuid){
        return this.repository.findById(UUID.fromString(uuid))
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "customer not found")));
    }

    public Mono<Customer> create(Customer customer){
        return this.repository.save(customer);
    }

    public Mono<Customer> update(String uuid, Customer customer) {
        return this.repository.save(customer.withUuid(UUID.fromString(uuid)));
    }


}
