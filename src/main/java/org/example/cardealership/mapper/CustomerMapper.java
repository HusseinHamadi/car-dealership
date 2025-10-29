package org.example.cardealership.mapper;

import org.example.cardealership.dto.CustomerCreateDTO;
import org.example.cardealership.dto.CustomerResponseDTO;
import org.example.cardealership.dto.CustomerUpdateDTO;
import org.example.cardealership.model.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface CustomerMapper {

    Customer customerCreateDtoToCustomer(CustomerCreateDTO customerCreateDTO);

    CustomerResponseDTO customerToCustomerResponseDto(Customer customer);

    Customer customerUpdateDtoToCustomer(CustomerUpdateDTO customerUpdateDTO);

}
