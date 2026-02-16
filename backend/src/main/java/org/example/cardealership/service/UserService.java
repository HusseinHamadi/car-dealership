package org.example.cardealership.service;


import org.example.cardealership.dto.UserCreateDTO;
import org.example.cardealership.dto.UserResponseDTO;
import org.example.cardealership.dto.UserUpdateDTO;

import java.util.List;

public interface UserService {
    List<UserResponseDTO> getAllUsers();

    UserResponseDTO getUserById(Long id);

    UserResponseDTO addUser(UserCreateDTO user);

    UserResponseDTO updateUser(UserUpdateDTO user, Long id);

    String deleteUser(Long id);
}
