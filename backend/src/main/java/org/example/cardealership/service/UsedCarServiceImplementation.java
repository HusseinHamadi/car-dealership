package org.example.cardealership.service;


import org.example.cardealership.dto.UsedCarCreateDTO;
import org.example.cardealership.dto.UsedCarResponseDTO;
import org.example.cardealership.dto.UsedCarUpdateDTO;
import org.example.cardealership.exception.NotFoundException;
import org.example.cardealership.helpers.StringFunctions;
import org.example.cardealership.mapper.UsedCarMapper;
import org.example.cardealership.model.UsedCar;
import org.example.cardealership.repository.UsedCarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UsedCarServiceImplementation implements UsedCarService {


    UsedCarRepository usedCarRepository;
    UsedCarMapper usedCarMapper;

    public UsedCarServiceImplementation(UsedCarRepository usedCarRepository, UsedCarMapper usedCarMapper) {
        this.usedCarRepository = usedCarRepository;
        this.usedCarMapper = usedCarMapper;
    }

    @Override
    public List<UsedCarResponseDTO> getAllUsedCars() {
        return usedCarRepository.findAll()
                .stream()
                .map(usedCar -> usedCarMapper.usedCarToUsedCarResponseDto(usedCar))
                .toList();
    }

    @Override
    public UsedCarResponseDTO getUsedCarById(Long id) {
        return usedCarRepository.findById(id)
                .map(rental -> usedCarMapper.usedCarToUsedCarResponseDto(rental))
                .orElseThrow(() -> new NotFoundException("Used Car with Id: " + id + " is not found."));
    }

    @Override
    public UsedCarResponseDTO addUsedCar(UsedCarCreateDTO usedCarDTO) {

        return usedCarMapper.usedCarToUsedCarResponseDto(
                usedCarRepository.save(usedCarMapper.usedCarCreateDtoToUsedCar(usedCarDTO))
        );
    }

    @Override
    public UsedCarResponseDTO updateUsedCar(UsedCarUpdateDTO usedCarDTO, Long id) {
        Optional<UsedCar> usedCarOptional = usedCarRepository.findById(id);
        if (usedCarOptional.isEmpty()) {
            throw new NotFoundException("Used Car with Id: " + id + " is not found.");
        }

        UsedCar usedCar = usedCarOptional.get();

        if (StringFunctions.notNullAndNotEmpty(usedCarDTO.brand())) {
            usedCar.setBrand(usedCarDTO.brand());
        }
        if (StringFunctions.notNullAndNotEmpty(usedCarDTO.model())) {
            usedCar.setModel(usedCarDTO.model());
        }
        if (usedCarDTO.year() != null) {
            usedCar.setYear(usedCarDTO.year());
        }
        if (Objects.nonNull(usedCarDTO.status())) {
            usedCar.setStatus(usedCarDTO.status());
        }
        if (usedCarDTO.basePrice() != null) {
            usedCar.setBasePrice(usedCarDTO.basePrice());
        }
        if (usedCarDTO.mileage() != null) {
            usedCar.setMileage(usedCarDTO.mileage());
        }

        return usedCarMapper.usedCarToUsedCarResponseDto(
                usedCarRepository.save(usedCar)
        );
    }

    @Override
    public String deleteUsedCar(Long id) {
        UsedCar usedCar = usedCarRepository.findById(id).orElseThrow(() -> new NotFoundException("Rental Car with Id: " + id + " is not found."));

        usedCarRepository.delete(usedCar);

        return "Used Car with Id: " + id + " is deleted successfully.";
    }
}
