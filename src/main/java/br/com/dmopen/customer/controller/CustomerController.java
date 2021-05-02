package br.com.dmopen.customer.controller;

import br.com.dmopen.customer.controller.mapper.CustomerMapper;
import br.com.dmopen.customer.controller.request.CustomerRequest;
import br.com.dmopen.customer.controller.response.CustomerResponse;
import br.com.dmopen.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    private final CustomerMapper customerMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<CustomerResponse> create(@RequestBody CustomerRequest customer) {
        return Mono.just(customer)
                .map(customerMapper::toModel)
                .flatMap(customerService::create)
                .map(customerMapper::todResponse);
    }


    @GetMapping("/{customerUuid}")
    public Mono<CustomerResponse> findById(@PathVariable String customerUuid) {
        return Mono.just(customerUuid)
                .flatMap(customerService::findByUuid)
                .map(customerMapper::todResponse);
    }

    @PutMapping("/{customerUuid}")
    public Mono<CustomerResponse> update(
            @PathVariable String customerUuid,
            @RequestBody CustomerRequest customer) {
        return Mono.zip(Mono.just(customerUuid), Mono.just(customerMapper.toModel(customer)))
                .flatMap(tuple -> customerService.update(tuple.getT1(), tuple.getT2())) //TODO Improve this
                .map(customerMapper::todResponse);
    }

}
