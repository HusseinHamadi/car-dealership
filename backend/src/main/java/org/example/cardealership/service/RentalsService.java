package org.example.cardealership.service;


import jakarta.validation.Valid;
import org.example.cardealership.dto.RentalsCreateDTO;
import org.example.cardealership.dto.RentalsResponseDTO;
import org.example.cardealership.dto.RentalsUpdateDTO;

import java.util.List;

public interface RentalsService {
    List<RentalsResponseDTO> getAllRentals();

    RentalsResponseDTO getRentalsById(Long id);

    RentalsResponseDTO addRentals(@Valid RentalsCreateDTO rentalsDTO);

    RentalsResponseDTO updateRentals(RentalsUpdateDTO rentalsDTO, Long id);

    String deleteRentals(Long id);
}
