package org.example.cardealership.service;


import org.example.cardealership.exception.ConflictException;
import org.example.cardealership.exception.NotFoundException;
import org.example.cardealership.model.Customer;
import org.example.cardealership.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class CustomerServiceImplementation implements CustomerService{

    private final CustomerRepository customerRepository;

    private static final Logger logger = Logger.getLogger(CustomerServiceImplementation.class.getName());


    public CustomerServiceImplementation(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }
    @Override
    public List<Customer> getAllCustomers() {
        logger.info("Getting all customers: Service");

        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new NotFoundException("Customer with id: "+id+" does not exist"));
    }

    @Override
    public Customer addCustomer(Customer customer) {
        Optional<Customer> presentCustomer = customerRepository.findCustomerByEmail(customer.getEmail());
        if(presentCustomer.isPresent()){
            throw new ConflictException("Email \""+ presentCustomer.get().getEmail() +"\" already exists");
        }
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer, Long id) {
        Optional<Customer> updateCustomer = customerRepository.findById(id);
        if(updateCustomer.isEmpty()){
            throw new NotFoundException("Customer with id: "+id+" does not exist");
        }
        if(!updateCustomer.get().getEmail().equals(customer.getEmail())){
            updateCustomer.get().setEmail(customer.getEmail());
        }
        return updateCustomer.get();
    }
}
