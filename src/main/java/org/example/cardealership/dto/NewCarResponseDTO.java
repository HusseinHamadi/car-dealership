package org.example.cardealership.dto;

import org.example.cardealership.enums.Status;

import java.math.BigDecimal;

public record NewCarResponseDTO(Long id,
                                String brand,
                                String model,
                                Integer year,
                                Status status,
                                BigDecimal basePrice,
                                Integer warranty

) {
}
