package org.example.cardealership.dto;

import java.math.BigDecimal;

public record SalesResponseDTO( Long id,
                                BigDecimal finalPrice,
                                String brand,
                                String model,
                                Integer warrantyYears, // null if used
                                Long mileage, // null if new
                                Integer year,
                                UserResponseDTO user,
                                CustomerResponseDTO customer
) {
}
