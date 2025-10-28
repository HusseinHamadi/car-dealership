package org.example.cardealership.dto;

import org.example.cardealership.enums.Status;

import java.math.BigDecimal;

public record RentalsUpdateDTO(String brand,
                               String model,
                               int year,
                               Status status,
                               BigDecimal dailyRate

) {
}
