package org.example.cardealership.mapper;

import org.example.cardealership.dto.UserCreateDTO;
import org.example.cardealership.dto.UserResponseDTO;
import org.example.cardealership.dto.UserUpdateDTO;
import org.example.cardealership.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    User userCreateDtoToUser(UserCreateDTO userCreateDTO);

    UserResponseDTO userToUserResponseDto(User user);

    User userUpdateDtoToUser(UserUpdateDTO userUpdateDTO);
}
