package org.example.cardealership.mapper;

import org.example.cardealership.dto.RentalsCreateDTO;
import org.example.cardealership.dto.RentalsResponseDTO;
import org.example.cardealership.dto.RentalsUpdateDTO;
import org.example.cardealership.model.Rentals;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CustomerMapper.class, UserMapper.class, RentalCarMapper.class})
public interface RentalsMapper {


    Rentals rentalsCreateDtoToRentals(RentalsCreateDTO rentalsCreateDTO);

    Rentals rentalsUpdateDtoToRentals(RentalsUpdateDTO rentalsUpdateDTO);


    //    @Mappings({
//            @Mapping(target = "brand", source = "rentalCar.brand"),
//            @Mapping(target = "model", source = "rentalCar.model"),
//            @Mapping(target = "year", source = "rentalCar.year"),
//            @Mapping(target = "status", source = "rentalCar.status"),
//            @Mapping(target = "dailyRate", source = "rentalCar.dailyRate")
//    })
    RentalsResponseDTO rentalsToRentalResponseDto(Rentals rentals);


}
