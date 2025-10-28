package org.example.cardealership.dto;

import jakarta.validation.constraints.NotBlank;
import org.example.cardealership.enums.Status;

public record NewCarUpdateDTO( String brand,
                               String model,
                               int year,
                               Status status,
                              int warranty

) {
}
