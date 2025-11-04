package org.example.cardealership.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import org.example.cardealership.enums.Status;

import java.math.BigDecimal;

public record UsedCarCreateDTO(
        @NotBlank(message = "Car brand is required.")
        String brand,

        @NotBlank(message = "Car model is required.")
        String model,

        @NotNull(message = "Manufacturing year is required.")
        @Min(value = 1886, message = "Year must be no earlier than 1886 (the first car).")
        Integer year,

        @NotNull(message = "Car status is required.")
        Status status,

        @NotNull(message = "Base price is required.")
        @PositiveOrZero(message = "Base price must be zero or positive.")
        BigDecimal basePrice,

        @PositiveOrZero(message = "Mileage must be zero or positive.")
        Long mileage
) { }
