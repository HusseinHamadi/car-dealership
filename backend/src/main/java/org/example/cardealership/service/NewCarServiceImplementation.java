package org.example.cardealership.service;


import org.example.cardealership.dto.NewCarCreateDTO;
import org.example.cardealership.dto.NewCarResponseDTO;
import org.example.cardealership.dto.NewCarUpdateDTO;
import org.example.cardealership.exception.NotFoundException;
import org.example.cardealership.helpers.StringFunctions;
import org.example.cardealership.mapper.NewCarMapper;
import org.example.cardealership.model.NewCar;
import org.example.cardealership.repository.NewCarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class NewCarServiceImplementation implements NewCarService {


    NewCarRepository newCarRepository;
    NewCarMapper newCarMapper;

    public NewCarServiceImplementation(NewCarRepository newCarRepository, NewCarMapper newCarMapper) {
        this.newCarRepository = newCarRepository;
        this.newCarMapper = newCarMapper;
    }

    @Override
    public List<NewCarResponseDTO> getAllNewCars() {
        return newCarRepository.findAll()
                .stream()
                .map(newCar -> newCarMapper.newCarToNewCarResponseDto(newCar))
                .toList();
    }

    @Override
    public NewCarResponseDTO getNewCarById(Long id) {
        return newCarRepository.findById(id)
                .map(rental -> newCarMapper.newCarToNewCarResponseDto(rental))
                .orElseThrow(() -> new NotFoundException("New Car with Id: " + id + " is not found."));
    }

    @Override
    public NewCarResponseDTO addNewCar(NewCarCreateDTO newCarDTO) {

        return newCarMapper.newCarToNewCarResponseDto(
                newCarRepository.save(newCarMapper.newCarCreateDtoToNewCar(newCarDTO))
        );
    }

    @Override
    public NewCarResponseDTO updateNewCar(NewCarUpdateDTO newCarDTO, Long id) {
        Optional<NewCar> newCarOptional = newCarRepository.findById(id);
        if (newCarOptional.isEmpty()) {
            throw new NotFoundException("New Car with Id: " + id + " is not found.");
        }

        NewCar newCar = newCarOptional.get();

        if (StringFunctions.notNullAndNotEmpty(newCarDTO.brand())) {
            newCar.setBrand(newCarDTO.brand());
        }
        if (StringFunctions.notNullAndNotEmpty(newCarDTO.model())) {
            newCar.setModel(newCarDTO.model());
        }
        if (newCarDTO.year() != null) {
            newCar.setYear(newCarDTO.year());
        }
        if (Objects.nonNull(newCarDTO.status())) {
            newCar.setStatus(newCarDTO.status());
        }
        if (newCarDTO.basePrice() != null) {
            newCar.setBasePrice(newCarDTO.basePrice());
        }
        if (newCarDTO.warranty() != null) {
            newCar.setWarranty(newCarDTO.warranty());
        }

        return newCarMapper.newCarToNewCarResponseDto(
                newCarRepository.save(newCar)
        );
    }

    @Override
    public String deleteNewCar(Long id) {
        NewCar newCar = newCarRepository.findById(id).orElseThrow(() -> new NotFoundException("Rental Car with Id: " + id + " is not found."));

        newCarRepository.delete(newCar);

        return "New Car with Id: " + id + " is deleted successfully.";
    }
}
