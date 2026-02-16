package org.example.cardealership.service;


import org.example.cardealership.dto.CustomerCreateDTO;
import org.example.cardealership.dto.CustomerResponseDTO;
import org.example.cardealership.dto.CustomerUpdateDTO;
import org.example.cardealership.exception.ConflictException;
import org.example.cardealership.exception.NotFoundException;
import org.example.cardealership.helpers.StringFunctions;
import org.example.cardealership.mapper.CustomerMapper;
import org.example.cardealership.model.Customer;
import org.example.cardealership.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class CustomerServiceImplementation implements CustomerService {

    private final CustomerRepository customerRepository;


    private final CustomerMapper customerMapper;


    private static final Logger logger = Logger.getLogger(CustomerServiceImplementation.class.getName());


    public CustomerServiceImplementation(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }


    @Override
    public List<CustomerResponseDTO> getAllCustomers() {
        logger.info("Getting all customers: Service");

        return customerRepository.findAll()
                .stream()
                .map(customer -> customerMapper.customerToCustomerResponseDto(customer))
                .toList();
    }

    @Override
    public CustomerResponseDTO getCustomerById(Long id) {
        return customerRepository.findById(id)
                .map(customer -> customerMapper.customerToCustomerResponseDto(customer))
                .orElseThrow(() -> new NotFoundException("Customer with id: " + id + " does not exist"));
    }

    @Override
    public CustomerResponseDTO addCustomer(CustomerCreateDTO customerDTO) {
        Optional<Customer> presentCustomer = customerRepository.findCustomerByEmail(customerDTO.email());
        if (presentCustomer.isPresent()) {
            throw new ConflictException("Email \"" + presentCustomer.get().getEmail() + "\" already exists");
        }
        Customer customer = customerMapper.customerCreateDtoToCustomer(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.customerToCustomerResponseDto(savedCustomer);
    }

    @Override
    public CustomerResponseDTO updateCustomer(CustomerUpdateDTO customerDTO, Long id) {
        Optional<Customer> foundCustomer = customerRepository.findById(id);
        if (foundCustomer.isEmpty()) {
            throw new NotFoundException("Customer with id: " + id + " does not exist");
        }

        Customer updateCustomer = foundCustomer.get();

        if (StringFunctions.notNullAndNotEmpty(customerDTO.firstName())) {
            updateCustomer.setFirstName(customerDTO.firstName());
        }
        if (StringFunctions.notNullAndNotEmpty(customerDTO.lastName())) {
            updateCustomer.setLastName(customerDTO.lastName());
        }
        if (StringFunctions.notNullAndNotEmpty(customerDTO.phoneNumber())) {
            updateCustomer.setPhoneNumber(customerDTO.phoneNumber());
        }
        if (StringFunctions.notNullAndNotEmpty(customerDTO.email())) {
            updateCustomer.setEmail(customerDTO.email());
        }
        if (StringFunctions.notNullAndNotEmpty(customerDTO.address())) {
            updateCustomer.setAddress(customerDTO.address());
        }
        Customer savedCustomer = customerRepository.save(updateCustomer);
        return customerMapper.customerToCustomerResponseDto(savedCustomer);
    }

    @Override
    public String deleteCustomer(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty()) {
            throw new NotFoundException("Customer with id: " + id + " is not found");
        }
        customerRepository.delete(customer.get());
        return "Customer with id: " + id + " is deleted successfully";
    }
}
