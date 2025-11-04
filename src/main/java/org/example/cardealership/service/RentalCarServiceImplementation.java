package org.example.cardealership.service;


import org.example.cardealership.dto.RentalCarCreateDTO;
import org.example.cardealership.dto.RentalCarResponseDTO;
import org.example.cardealership.dto.RentalCarUpdateDTO;
import org.example.cardealership.exception.NotFoundException;
import org.example.cardealership.helpers.StringFunctions;
import org.example.cardealership.mapper.RentalCarMapper;
import org.example.cardealership.model.RentalCar;
import org.example.cardealership.repository.RentalCarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RentalCarServiceImplementation implements RentalCarService{

    RentalCarRepository rentalCarRepository;
    RentalCarMapper rentalCarMapper;

    public RentalCarServiceImplementation(RentalCarRepository rentalCarRepository, RentalCarMapper rentalCarMapper){
        this.rentalCarRepository= rentalCarRepository;
        this.rentalCarMapper = rentalCarMapper;
    }

    @Override
    public List<RentalCarResponseDTO> getAllRentalCars() {
        return rentalCarRepository.findAll()
                .stream()
                .map(rentalCar -> rentalCarMapper.rentalCarToRentalCarResponseDto(rentalCar))
                .toList();
    }

    @Override
    public RentalCarResponseDTO getRentalCarById(Long id) {
        return rentalCarRepository.findById(id)
                .map(rental -> rentalCarMapper.rentalCarToRentalCarResponseDto(rental))
                .orElseThrow(() -> new NotFoundException("Rental Car with Id: " + id + " is not found."));
    }

    @Override
    public RentalCarResponseDTO addRentalCar(RentalCarCreateDTO rentalCarDTO) {

        return rentalCarMapper.rentalCarToRentalCarResponseDto(
                rentalCarRepository.save(rentalCarMapper.rentalCarCreateDtoToRentalCar(rentalCarDTO))
        );
    }

    @Override
    public RentalCarResponseDTO updateRentalCar(RentalCarUpdateDTO rentalCarDTO, Long id) {
        Optional<RentalCar> rentalCarOptional = rentalCarRepository.findById(id);
        if(rentalCarOptional.isEmpty()){
            throw new NotFoundException("Rental Car with Id: " + id + " is not found.");
        }

        RentalCar rentalCar = rentalCarOptional.get();

        if(StringFunctions.notNullAndNotEmpty(rentalCarDTO.brand())){
            rentalCar.setBrand(rentalCarDTO.brand());
        }
        if(StringFunctions.notNullAndNotEmpty(rentalCarDTO.model())){
            rentalCar.setModel(rentalCarDTO.model());
        }
        if(rentalCarDTO.year() != null){
            rentalCar.setYear(rentalCarDTO.year());
        }
        if(Objects.nonNull(rentalCarDTO.status())){
            rentalCar.setStatus(rentalCarDTO.status());
        }
        if(rentalCarDTO.dailyRate() != null){
            rentalCar.setDailyRate(rentalCarDTO.dailyRate());
        }

        return rentalCarMapper.rentalCarToRentalCarResponseDto(
                rentalCarRepository.save(rentalCar)
        );
    }

    @Override
    public String deleteRentalCar(Long id) {
        RentalCar rentalCar = rentalCarRepository.findById(id).orElseThrow(()-> new NotFoundException("Rental Car with Id: " + id + " is not found."));

        rentalCarRepository.delete(rentalCar);

        return "Rental Car with Id: " + id + " is deleted successfully.";
    }
}
