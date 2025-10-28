package org.example.cardealership.dto;

import org.example.cardealership.enums.Status;
import org.example.cardealership.model.Car;
import org.example.cardealership.model.RentalCar;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record RentalsResponseDTO(String brand,
                                 String model,
                                 int year,
                                 Status status,
                                 BigDecimal dailyRate,
                                 LocalDateTime rentStart,
                                 LocalDateTime rentEnd,
                                 BigDecimal totalPrice,
                                 UserResponseDTO user,
                                 CustomerResponseDTO customer


) {
}
