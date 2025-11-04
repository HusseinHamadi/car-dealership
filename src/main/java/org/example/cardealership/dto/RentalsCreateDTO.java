package org.example.cardealership.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record RentalsCreateDTO(
        @NotNull(message = "Rent start date and time is required.")
        LocalDateTime rentStart,

        @NotNull(message = "Rent end date and time is required.")
        LocalDateTime rentEnd,

        @NotNull(message = "Total price is required.")
        @DecimalMin(value = "0.0", inclusive = false, message = "Total price must be greater than zero.")
        BigDecimal totalPrice,

        @NotNull(message = "User ID is required.")
        Long userId,

        @NotNull(message = "Customer ID is required.")
        Long customerId,

        @NotNull(message = "Sale car ID is required.")
        Long saleCarId
) { }
