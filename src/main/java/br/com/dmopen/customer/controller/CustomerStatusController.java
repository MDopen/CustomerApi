package br.com.dmopen.customer.controller;

import br.com.dmopen.customer.controller.mapper.CustomerMapper;
import br.com.dmopen.customer.controller.mapper.CustomerStatusMapper;
import br.com.dmopen.customer.controller.request.CustomerRequest;
import br.com.dmopen.customer.controller.response.CustomerResponse;
import br.com.dmopen.customer.controller.response.CustomerStatusResponse;
import br.com.dmopen.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/customer/{customerUuid}/status")
@RequiredArgsConstructor
@Slf4j
public class CustomerStatusController {

    private final CustomerService customerService;

    private final CustomerStatusMapper statusMapper;

    @GetMapping
    public Mono<CustomerStatusResponse> findById(@PathVariable String customerUuid) {
        return Mono.just(customerUuid)
                .flatMap(customerService::findByUuid)
                .map(statusMapper::todResponse)
                .log("CustomerStatusController.findById");
    }

}
