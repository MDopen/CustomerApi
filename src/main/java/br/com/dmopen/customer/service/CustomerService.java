package br.com.dmopen.customer.service;

import br.com.dmopen.customer.model.Customer;
import br.com.dmopen.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository repository;

    public List<Customer> findAll(){
        return this.repository.findAll();
    }

    public Customer findByUuid(String uuid){
        return this.repository.findById(uuid).orElse(new Customer());
    }

    public Customer create(Customer customer){
        return this.repository.save(customer);
    }

    public Customer update(String uuid, Customer customer) {
        return this.repository.save(customer.withUuid(uuid));
    }
}
