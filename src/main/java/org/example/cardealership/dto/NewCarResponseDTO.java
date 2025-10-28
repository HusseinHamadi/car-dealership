package org.example.cardealership.dto;

import org.example.cardealership.enums.Status;

import java.time.LocalDateTime;

public record NewCarResponseDTO(String brand,
                                String model,
                                int year,
                                Status status,
                                int warranty

) {
}
