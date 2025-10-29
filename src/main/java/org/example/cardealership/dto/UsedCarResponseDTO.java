package org.example.cardealership.dto;

import org.example.cardealership.enums.Status;

public record UsedCarResponseDTO(Long id,
                                 String brand,
                                 String model,
                                 int year,
                                 Status status,
                                 Long mileage

) {
}
