package org.example.cardealership.dto;

import jakarta.validation.constraints.NotBlank;
import org.example.cardealership.enums.Status;
import org.example.cardealership.model.Customer;
import org.example.cardealership.model.SaleCar;
import org.example.cardealership.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record SalesResponseDTO( Long id,
                                BigDecimal finalPrice,
                                String brand,
                                String model,
                                int warrantyYears, // null if used
                                Long mileage, // null if new
                                int year,
                                UserResponseDTO user,
                                CustomerResponseDTO customer
) {
}
