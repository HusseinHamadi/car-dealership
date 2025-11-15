package org.example.cardealership.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record SalesCreateDTO(
        @NotNull(message = "Final price is required.")
        @DecimalMin(value = "0.0", inclusive = false, message = "Final price must be greater than zero.")
        BigDecimal finalPrice,

        @NotNull(message = "User ID is required.")
        Long userId,

        @NotNull(message = "Customer ID is required.")
        Long customerId,

        @NotNull(message = "Sale car ID is required.")
        Long saleCarId
) {

}

