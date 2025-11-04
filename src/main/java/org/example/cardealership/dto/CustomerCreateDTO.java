package org.example.cardealership.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CustomerCreateDTO(
        @NotBlank(message = "First name is required.")
        String firstName,

        @NotBlank(message = "Last name is required.")
        String lastName,

        @NotBlank(message = "Phone number is required.")
        String phoneNumber,

        @Email(message = "Please provide a valid email address.")
        String email,

        @NotBlank(message = "Address is required.")
        String address
) { }

