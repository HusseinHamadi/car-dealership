package org.example.cardealership.dto;

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
