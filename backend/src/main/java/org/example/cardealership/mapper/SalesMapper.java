package org.example.cardealership.mapper;

import org.example.cardealership.dto.SalesCreateDTO;
import org.example.cardealership.dto.SalesResponseDTO;
import org.example.cardealership.dto.SalesUpdateDTO;
import org.example.cardealership.model.Sales;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

//we used the saleCarMapper to map the sales.saleCar to saleCarResponseDTO because it's an interface of new and used car
@Mapper(componentModel = "spring", uses = {UserMapper.class, CustomerMapper.class, SaleCarMapper.class})
public interface SalesMapper {

    Sales salesCreateDtoToSales(SalesCreateDTO salesCreateDTO);

    Sales salesUpdateDtoToSales(SalesUpdateDTO salesUpdateDTO);
//
//    @SubclassMapping(source = NewCar.class, target = NewCarResponseDTO.class)
//    @SubclassMapping(source = UsedCar.class, target = UsedCarResponseDTO.class)
//    SaleCarResponseDTO mapSaleCarToResponse(Car saleCar);

    @Mapping(source = "user", target = "user")
    @Mapping(source = "customer", target = "customer")
    @Mapping(source = "saleCar", target = "saleCar")
    @Mapping(source = "finalPrice", target = "finalPrice")
    SalesResponseDTO salesToSalesResponseDto(Sales sales);
}
