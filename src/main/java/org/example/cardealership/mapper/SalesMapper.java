package org.example.cardealership.mapper;

import org.example.cardealership.dto.SalesCreateDTO;
import org.example.cardealership.dto.SalesResponseDTO;
import org.example.cardealership.dto.SalesUpdateDTO;
import org.example.cardealership.model.Sales;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface SalesMapper {

    Sales salesUpdateDtoToSales(SalesCreateDTO salesCreateDTO);

    @Mappings({
            @Mapping(target = "brand", source = "rentalCar.brand"),
            @Mapping(target = "model", source = "rentalCar.model"),
            @Mapping(target = "year", source = "rentalCar.year"),
            @Mapping(target = "status", source = "rentalCar.status"),
            @Mapping(target = "dailyRate", source = "rentalCar.dailyRate"),
    })
    SalesResponseDTO salesToSalesResponseDto(Sales sales);

    Sales salesUpdateDtoToSales(SalesUpdateDTO salesUpdateDTO);
}
