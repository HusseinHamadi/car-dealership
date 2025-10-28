package org.example.cardealership.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.example.cardealership.enums.Status;

import java.math.BigDecimal;

public record RentalCarCreateDTO(@NotBlank String brand,
                                 @NotBlank String model,
                                 @NotNull int year,
                                 @NotBlank Status status,
                                 @NotBlank BigDecimal dailyRate

) {
}
