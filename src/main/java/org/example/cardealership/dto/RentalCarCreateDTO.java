package org.example.cardealership.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.example.cardealership.enums.Status;

import java.math.BigDecimal;

import jakarta.validation.constraints.*;


public record RentalCarCreateDTO(
        @NotBlank(message = "Brand is required and cannot be blank")
        String brand,

        @NotBlank(message = "Model is required and cannot be blank")
        String model,

        @NotNull(message = "Year is required")
        @Min(value = 1886, message = "Year must be no earlier than 1886.")
        Integer year,

        @NotNull(message = "Status is required")
        Status status,

        @NotNull(message = "Daily rate is required")
        @DecimalMin(value = "0.0", inclusive = false, message = "Daily rate must be greater than zero.")
        BigDecimal dailyRate
) {}


