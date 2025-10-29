package org.example.cardealership.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.example.cardealership.enums.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record SalesCreateDTO(@NotNull BigDecimal finalPrice,
                             @NotNull Long userId,
                             @NotNull Long customerId,
                             @NotNull Long saleCarId


) {
}
