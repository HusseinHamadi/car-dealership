package org.example.cardealership.service;

import jakarta.validation.Valid;
import org.example.cardealership.dto.NewCarCreateDTO;
import org.example.cardealership.dto.NewCarResponseDTO;
import org.example.cardealership.dto.NewCarUpdateDTO;

import java.util.List;

public interface NewCarService {
    List<NewCarResponseDTO> getAllNewCars();

    NewCarResponseDTO getNewCarById(Long id);

    NewCarResponseDTO addNewCar(@Valid NewCarCreateDTO newCarDTO);

    NewCarResponseDTO updateNewCar(NewCarUpdateDTO newCarDTO, Long id);

    String deleteNewCar(Long id);
}
