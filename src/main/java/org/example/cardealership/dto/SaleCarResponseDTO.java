package org.example.cardealership.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.example.cardealership.enums.Status;

import java.math.BigDecimal;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.WRAPPER_OBJECT
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = NewCarResponseDTO.class, name = "newCar"),
        @JsonSubTypes.Type(value = UsedCarResponseDTO.class, name = "usedCar")
})
public sealed interface SaleCarResponseDTO permits NewCarResponseDTO, UsedCarResponseDTO {
    Long id();

    String brand();

    String model();

    Integer year();

    Status status();

    BigDecimal finalPrice();
}