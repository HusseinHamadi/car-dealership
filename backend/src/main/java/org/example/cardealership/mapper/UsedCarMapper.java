package org.example.cardealership.mapper;

import org.example.cardealership.dto.UsedCarCreateDTO;
import org.example.cardealership.dto.UsedCarResponseDTO;
import org.example.cardealership.dto.UsedCarUpdateDTO;
import org.example.cardealership.model.UsedCar;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsedCarMapper {

    UsedCar usedCarCreateDtoToUsedCar(UsedCarCreateDTO usedCarCreateDTO);

    UsedCarResponseDTO usedCarToUsedCarResponseDto(UsedCar usedCar);

    UsedCar usedCarUpdateDtoToUsedCar(UsedCarUpdateDTO usedCarUpdateDTO);
}
