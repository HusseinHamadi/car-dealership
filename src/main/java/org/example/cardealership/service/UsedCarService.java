package org.example.cardealership.service;


import jakarta.validation.Valid;
import org.example.cardealership.dto.UsedCarCreateDTO;
import org.example.cardealership.dto.UsedCarResponseDTO;
import org.example.cardealership.dto.UsedCarUpdateDTO;

import java.util.List;

public interface UsedCarService {
    List<UsedCarResponseDTO> getAllUsedCars();

    UsedCarResponseDTO getUsedCarById(Long id);

    UsedCarResponseDTO addUsedCar(@Valid UsedCarCreateDTO usedCarDTO);

    UsedCarResponseDTO updateUsedCar(UsedCarUpdateDTO usedCarDTO, Long id);

    String deleteUsedCar(Long id);
}
