package org.example.cardealership.dto;

import org.example.cardealership.enums.Role;

public record UserResponseDTO(Long id,
                              String firstName,
                              String lastName,
                              String email,
                              Role role
) {
}
