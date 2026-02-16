package org.example.cardealership.mapper;

import org.example.cardealership.dto.RentalCarCreateDTO;
import org.example.cardealership.dto.RentalCarResponseDTO;
import org.example.cardealership.dto.RentalCarUpdateDTO;
import org.example.cardealership.model.RentalCar;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RentalCarMapper {

    RentalCar rentalCarCreateDtoToRentalCar(RentalCarCreateDTO rentalCarCreateDTO);

    RentalCarResponseDTO rentalCarToRentalCarResponseDto(RentalCar rentalCar);

    RentalCar rentalCarUpdateToRentalCar(RentalCarUpdateDTO rentalCarUpdateDTO);
}
