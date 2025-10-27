package org.example.cardealership.controller;


import org.example.cardealership.model.Customer;
import org.example.cardealership.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/customers")
public class CustomerController {


    private static final Logger logger = Logger.getLogger(CustomerController.class.getName());

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(){
        logger.info("Getting all customers: Controller");
        List<Customer> customerList = customerService.getAllCustomers();
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("List", "Customers")
                .body(customerList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){
        Customer customer=customerService.getCustomerById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customer);
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        Customer savedCustomer = customerService.addCustomer(customer);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(savedCustomer);
    }


    @PostMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable Long id){
        Customer updatedCustomer = customerService.updateCustomer(customer, id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updatedCustomer);
    }

}
