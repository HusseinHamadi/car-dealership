package org.example.cardealership.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.example.cardealership.enums.Status;

public record NewCarCreateDTO(
        @NotBlank(message = "Car brand is required.")
        String brand,

        @NotBlank(message = "Car model is required.")
        String model,

        @NotNull(message = "Manufacturing year is required.")
        @Min(value = 1886, message = "Year must be no earlier than 1886 (the first car).")
        Integer year,

        @NotNull(message = "Car status is required.")
        Status status,

        @Positive(message = "Warranty period must be positive if specified.")
        Integer warranty
) { }
