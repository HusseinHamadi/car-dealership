package org.example.cardealership.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record CustomerResponseDTO(Long id,
                                  String firstName,
                                  String lastName,
                                  String phoneNumber,
                                  String email,
                                  String address,
                                  LocalDateTime createdAt

) {
}
