package org.example.cardealership.service;

import org.example.cardealership.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> getAllCustomers();

    Customer getCustomerById(Long id);

    Customer addCustomer(Customer customer);

    Customer updateCustomer(Customer customer, Long id);
}
