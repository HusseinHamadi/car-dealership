package org.example.cardealership.service;


import org.example.cardealership.dto.SalesCreateDTO;
import org.example.cardealership.dto.SalesResponseDTO;
import org.example.cardealership.dto.SalesUpdateDTO;
import org.example.cardealership.exception.NotFoundException;
import org.example.cardealership.mapper.SalesMapper;
import org.example.cardealership.model.*;
import org.example.cardealership.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SalesServiceImplementation implements SalesService {

    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final NewCarRepository newCarRepository;
    private final UsedCarRepository usedCarRepository;
    SalesRepository salesRepository;
    SalesMapper salesMapper;

    public SalesServiceImplementation(SalesRepository salesRepository, SalesMapper salesMapper, UserRepository userRepository, CustomerRepository customerRepository, NewCarRepository newCarRepository, UsedCarRepository usedCarRepository) {
        this.salesRepository = salesRepository;
        this.salesMapper = salesMapper;
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
        this.newCarRepository = newCarRepository;
        this.usedCarRepository = usedCarRepository;
    }

    @Override
    public List<SalesResponseDTO> getAllSales() {
        return salesRepository.findAll()
                .stream()
                .map(saleRecord -> salesMapper.salesToSalesResponseDto(saleRecord))
                .toList();
    }

    @Override
    public SalesResponseDTO getSalesById(Long id) {

        return salesMapper.salesToSalesResponseDto(
                salesRepository.findById(id).orElseThrow(() -> new NotFoundException("Sale Record with id: " + id + " is not found."))
        );
    }

    @Override
    public SalesResponseDTO addSales(SalesCreateDTO salesDTO) {
        User user = userRepository.findById(salesDTO.userId())
                .orElseThrow(() -> new NotFoundException("User not found"));

        Customer customer = customerRepository.findById(salesDTO.customerId())
                .orElseThrow(() -> new NotFoundException("Customer not found"));

        NewCar newCar = newCarRepository.findById(salesDTO.saleCarId()).orElse(null);
        UsedCar usedCar = usedCarRepository.findById(salesDTO.saleCarId()).orElse(null);

        if (newCar == null && usedCar == null) {
            throw new NotFoundException("Car not found.");
        }
        Sales saleRecord = salesMapper.salesCreateDtoToSales(salesDTO);
        saleRecord.setUser(user);
        saleRecord.setCustomer(customer);

        saleRecord.setSaleCar(Objects.requireNonNullElse(newCar, usedCar));

        Sales saved = salesRepository.save(saleRecord);
        return salesMapper.salesToSalesResponseDto(saved);
    }


    @Override
    public SalesResponseDTO updateSales(SalesUpdateDTO salesDTO, Long id) {

        Sales existingSale = salesRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Sale not found with id " + id));

        if (salesDTO.finalPrice() != null) {
            existingSale.setFinalPrice(salesDTO.finalPrice());
        }


        Sales updatedSale = salesRepository.save(existingSale);

        return salesMapper.salesToSalesResponseDto(updatedSale);
    }

    @Override
    public String deleteSales(Long id) {

        Sales sale = salesRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Sale not found with id " + id));

        salesRepository.delete(sale);

        return "Sale with id " + id + " has been deleted successfully.";
    }
}
