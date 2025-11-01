package org.example.cardealership.controller;


import org.example.cardealership.dto.CustomerCreateDTO;
import org.example.cardealership.dto.CustomerResponseDTO;
import org.example.cardealership.dto.CustomerUpdateDTO;
import org.example.cardealership.mapper.CustomerMapper;
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
    public ResponseEntity<List<CustomerResponseDTO>> getAllCustomers(){
        logger.info("Getting all customers: Controller");
        List<CustomerResponseDTO> customerList = customerService.getAllCustomers();
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("List", "Customers")
                .body(customerList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> getCustomerById(@PathVariable Long id){
        CustomerResponseDTO customer=customerService.getCustomerById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customer);
    }

    @PostMapping
    public ResponseEntity<CustomerResponseDTO> addCustomer(@RequestBody CustomerCreateDTO customer){
        CustomerResponseDTO savedCustomer = customerService.addCustomer(customer);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(savedCustomer);
    }


    @PostMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> updateCustomer(@RequestBody CustomerUpdateDTO customer, @PathVariable Long id){
        CustomerResponseDTO updatedCustomer = customerService.updateCustomer(customer, id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updatedCustomer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long id){
        String message=customerService.deleteCustomer(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(message);
    }

}
