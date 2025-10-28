package org.example.cardealership.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.example.cardealership.enums.Status;

public record NewCarCreateDTO(@NotBlank String brand,
                              @NotBlank String model,
                              @NotNull int year,
                              @NotNull Status status,
                              int warranty

) {
}
