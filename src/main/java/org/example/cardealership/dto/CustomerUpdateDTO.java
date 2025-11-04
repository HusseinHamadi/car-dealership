package org.example.cardealership.dto;

public record CustomerUpdateDTO( String firstName,
                                 String lastName,
                                 String phoneNumber,
                                 String email,
                                 String address
) {
}
