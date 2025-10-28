package org.example.cardealership.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CustomerUpdateDTO( String firstName,
                                 String lastName,
                                 String phoneNumber,
                                 String email,
                                 String address
) {
}
