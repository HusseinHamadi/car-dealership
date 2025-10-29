package org.example.cardealership.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.example.cardealership.enums.Role;

public record UserCreateDTO(@NotBlank String firstName,
                            @NotBlank String lastName,
                            @NotBlank String phoneNumber,
                            @Email String email,
                            @NotBlank String username,
                            @NotBlank String password,
                            @NotBlank Role role
) {
}
