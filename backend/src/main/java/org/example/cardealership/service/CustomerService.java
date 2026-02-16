package org.example.cardealership.service;

import org.example.cardealership.dto.CustomerCreateDTO;
import org.example.cardealership.dto.CustomerResponseDTO;
import org.example.cardealership.dto.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerResponseDTO> getAllCustomers();

    CustomerResponseDTO getCustomerById(Long id);

    CustomerResponseDTO addCustomer(CustomerCreateDTO customer);

    CustomerResponseDTO updateCustomer(CustomerUpdateDTO customer, Long id);

    String deleteCustomer(Long id);
}
