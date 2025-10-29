package org.example.cardealership.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.example.cardealership.enums.Status;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record RentalsCreateDTO(@NotNull LocalDateTime rentStart,
                               @NotBlank LocalDateTime rentEnd,
                               @NotBlank BigDecimal totalPrice,
                               @NotNull Long userId,
                               @NotNull Long customerId,
                               @NotNull Long saleCarId

) {
}
