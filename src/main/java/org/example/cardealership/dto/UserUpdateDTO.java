package org.example.cardealership.dto;

import org.example.cardealership.enums.Role;

public record UserUpdateDTO( String firstName,
                             String lastName,
                             String phoneNumber,
                             String email,
                             String username,
                             String password,
                             Role role
) {
}
