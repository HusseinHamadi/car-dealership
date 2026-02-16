package org.example.cardealership.service;


import org.example.cardealership.dto.RentalCarCreateDTO;
import org.example.cardealership.dto.RentalCarResponseDTO;
import org.example.cardealership.dto.RentalCarUpdateDTO;

import java.util.List;

public interface RentalCarService {
    List<RentalCarResponseDTO> getAllRentalCars();

    RentalCarResponseDTO getRentalCarById(Long id);

    RentalCarResponseDTO addRentalCar(RentalCarCreateDTO rentalCarDTO);

    RentalCarResponseDTO updateRentalCar(RentalCarUpdateDTO rentalCarDTO, Long id);

    String deleteRentalCar(Long id);
}
