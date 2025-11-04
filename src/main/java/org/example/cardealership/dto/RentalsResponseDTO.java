package org.example.cardealership.dto;

import org.example.cardealership.enums.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record RentalsResponseDTO(Long id,
                                 UserResponseDTO user,
                                 CustomerResponseDTO customer,
                                 String brand,
                                 String model,
                                 Integer year,
                                 Status status,
                                 BigDecimal dailyRate,
                                 LocalDateTime rentStart,
                                 LocalDateTime rentEnd,
                                 BigDecimal totalPrice
) {
}
