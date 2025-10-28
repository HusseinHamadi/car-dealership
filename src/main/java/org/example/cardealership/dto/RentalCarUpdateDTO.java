package org.example.cardealership.dto;

import jakarta.validation.constraints.NotBlank;
import org.example.cardealership.enums.Status;

import java.math.BigDecimal;

public record RentalCarUpdateDTO( String brand,
                                  String model,
                                  int year,
                                  Status status,
                                  BigDecimal dailyRate

) {
}
