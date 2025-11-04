package org.example.cardealership.dto;

import org.example.cardealership.enums.Status;

import java.math.BigDecimal;

public record NewCarUpdateDTO( String brand,
                               String model,
                               Integer year,
                               Status status,
                               BigDecimal basePrice,
                               Integer warranty

) {
}
