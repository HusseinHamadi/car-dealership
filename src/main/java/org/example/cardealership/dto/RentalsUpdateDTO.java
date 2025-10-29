package org.example.cardealership.dto;

import org.example.cardealership.enums.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record RentalsUpdateDTO(
        LocalDateTime rentStart,
        LocalDateTime rentEnd
) {
}
