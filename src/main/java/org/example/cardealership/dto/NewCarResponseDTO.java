package org.example.cardealership.dto;

import org.example.cardealership.enums.Status;

public record NewCarResponseDTO(Long id,
                                String brand,
                                String model,
                                Integer year,
                                Status status,
                                Integer warranty

) {
}
