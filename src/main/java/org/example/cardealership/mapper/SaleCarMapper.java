package org.example.cardealership.mapper;

import org.example.cardealership.dto.NewCarResponseDTO;
import org.example.cardealership.dto.SaleCarResponseDTO;
import org.example.cardealership.dto.UsedCarResponseDTO;
import org.example.cardealership.model.NewCar;
import org.example.cardealership.model.SaleCar;
import org.example.cardealership.model.UsedCar;
import org.mapstruct.Mapper;

// this is used to map from sale.saleCar to saleCarResponseDTO, since it's an interface of the records new and used cars
@Mapper(componentModel = "spring", uses = {NewCarMapper.class, UsedCarMapper.class})
public interface SaleCarMapper {

    default SaleCarResponseDTO mapCarToDto(SaleCar car) {
        if (car instanceof NewCar newCar) {
            return mapNewCar(newCar);  // delegates to NewCarMapper
        } else if (car instanceof UsedCar usedCar) {
            return mapUsedCar(usedCar);  // delegates to UsedCarMapper
        }
        throw new IllegalArgumentException("Unknown car type: " + car.getClass());
    }

    NewCarResponseDTO mapNewCar(NewCar newCar);  // MapStruct generates this using NewCarMapper

    UsedCarResponseDTO mapUsedCar(UsedCar usedCar);  // MapStruct generates this using UsedCarMapper
}
