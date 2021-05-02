package br.com.dmopen.customer.controller.mapper;

import br.com.dmopen.customer.CustomerStatusEnum;
import br.com.dmopen.customer.controller.request.CustomerRequest;
import br.com.dmopen.customer.controller.response.CustomerResponse;
import br.com.dmopen.customer.controller.response.CustomerStatusResponse;
import br.com.dmopen.customer.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface CustomerStatusMapper {

    CustomerStatusResponse todResponse(Customer model);

}
