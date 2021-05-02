package br.com.dmopen.customer.controller.mapper;

import br.com.dmopen.customer.controller.request.CustomerRequest;
import br.com.dmopen.customer.controller.response.CustomerResponse;
import br.com.dmopen.customer.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(source = "name", target = "name")
    Customer toModel(CustomerRequest request);

    @Mapping(source = "uuid", target = "customerUid", qualifiedByName = "uuidToString")
    @Mapping(source = "name", target = "name")
    CustomerResponse todResponse(Customer model);

    @Named("uuidToString")
    default String uuidToString(UUID uuid){
        return uuid.toString();
    }

    @Named("stringToUuid")
    default String stringToUuid(UUID uuid){
        return uuid.toString();
    }
}
