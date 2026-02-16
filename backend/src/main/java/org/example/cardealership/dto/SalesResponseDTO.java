package org.example.cardealership.dto;

import java.math.BigDecimal;

public record SalesResponseDTO(Long id,
                               BigDecimal finalPrice,
                               SaleCarResponseDTO saleCar,
                               UserResponseDTO user,
                               CustomerResponseDTO customer
) {
}
