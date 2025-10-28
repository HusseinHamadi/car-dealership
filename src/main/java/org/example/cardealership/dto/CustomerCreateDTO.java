package org.example.cardealership.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CustomerCreateDTO(@NotBlank String firstName,
                                @NotBlank String lastName,
                                @NotBlank String phoneNumber,
                                @Email String email,
                                @NotBlank String address
) {
}
