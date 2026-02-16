package org.example.cardealership.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record RentalsResponseDTO(Long id,
                                 UserResponseDTO user,
                                 CustomerResponseDTO customer,
                                 RentalCarResponseDTO rentalCar,
                                 LocalDateTime rentStart,
                                 LocalDateTime rentEnd,
                                 BigDecimal totalPrice
) {
}
