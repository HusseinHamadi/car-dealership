package org.example.cardealership.mapper;

import org.example.cardealership.dto.NewCarCreateDTO;
import org.example.cardealership.dto.NewCarResponseDTO;
import org.example.cardealership.dto.NewCarUpdateDTO;
import org.example.cardealership.model.NewCar;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NewCarMapper {

    NewCar newCarCreateDtoToNewCar(NewCarCreateDTO newCarCreateDTO);

    NewCarResponseDTO newCarToNewCarResponseDto(NewCar newCar);

    NewCar newCarUpdateDtoToNewCar(NewCarUpdateDTO newCarUpdateDTO);

}
