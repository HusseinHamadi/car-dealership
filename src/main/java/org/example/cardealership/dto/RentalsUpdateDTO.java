package org.example.cardealership.dto;

import java.time.LocalDateTime;

public record RentalsUpdateDTO(
        LocalDateTime rentStart,
        LocalDateTime rentEnd
) {
}
