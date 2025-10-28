package org.example.cardealership.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.example.cardealership.enums.Role;

public record UserUpdateDTO( String firstName,
                             String lastName,
                             String email,
                             String password,
                             Role role
) {
}
