package org.example.cardealership.mapper;

import org.example.cardealership.dto.SalesCreateDTO;
import org.example.cardealership.dto.SalesResponseDTO;
import org.example.cardealership.dto.SalesUpdateDTO;
import org.example.cardealership.model.Car;
import org.example.cardealership.model.NewCar;
import org.example.cardealership.model.Sales;
import org.example.cardealership.model.UsedCar;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.math.BigDecimal;

@Mapper(componentModel = "spring", uses = {UserMapper.class, CustomerMapper.class})
public interface SalesMapper {

    Sales salesUpdateDtoToSales(SalesCreateDTO salesCreateDTO);

    Sales salesUpdateDtoToSales(SalesUpdateDTO salesUpdateDTO);



    default SalesResponseDTO salesToSalesResponseDto(Sales sales, UserMapper userMapper, CustomerMapper customerMapper){

        if (sales == null) {
            return null;
        }

        Car car = sales.getSaleCar();

        Long id = car.getId();
        BigDecimal finalPrice = sales.getFinalPrice();
        String brand = car.getBrand();
        String model = car.getModel();
        int year = car.getYear();

        int warrantyYears = 0;
        Long mileage = 0L;

        if (car instanceof NewCar newCar) {
            warrantyYears = newCar.getWarranty();
        } else if (car instanceof UsedCar usedCar) {
            mileage = usedCar.getMileage();
        }

        return new SalesResponseDTO(
                id,
                finalPrice,
                brand,
                model,
                warrantyYears,
                mileage,
                year,
                userMapper.userToUserResponseDto(sales.getUser()),
                customerMapper.customerToCustomerResponseDto(sales.getCustomer())
        );


    }

}
