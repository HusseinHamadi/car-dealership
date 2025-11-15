package org.example.cardealership.service;


import org.example.cardealership.dto.UserCreateDTO;
import org.example.cardealership.dto.UserResponseDTO;
import org.example.cardealership.dto.UserUpdateDTO;
import org.example.cardealership.exception.ConflictException;
import org.example.cardealership.exception.NotFoundException;
import org.example.cardealership.helpers.StringFunctions;
import org.example.cardealership.mapper.UserMapper;
import org.example.cardealership.model.User;
import org.example.cardealership.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    UserRepository userRepository;
    UserMapper userMapper;

    public UserServiceImplementation(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(user -> userMapper.userToUserResponseDto(user))
                .toList();
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(u -> userMapper.userToUserResponseDto(u))
                .orElseThrow(() -> new NotFoundException("User with Id: " + id + " is not found"));
    }

    @Override
    public UserResponseDTO addUser(UserCreateDTO user) {
        if (userRepository.findByUsername(user.username()).isPresent()) {
            throw new ConflictException("Username already exists.");
        }
        if (userRepository.findByEmail(user.email()).isPresent()) {
            throw new ConflictException("Email already exists.");
        }

        User newUser = userMapper.userCreateDtoToUser(user);
        return userMapper.userToUserResponseDto(userRepository.save(newUser));
    }

    @Override
    public UserResponseDTO updateUser(UserUpdateDTO userDTO, Long id) {
        Optional<User> foundUser = userRepository.findById(id);
        if (foundUser.isEmpty()) {
            throw new NotFoundException("User with Id: " + id + " is not found");
        }
        User updateUser = foundUser.get();
        if (StringFunctions.notNullAndNotEmpty(userDTO.firstName())) {
            updateUser.setFirstName(userDTO.firstName());
        }
        if (StringFunctions.notNullAndNotEmpty(userDTO.lastName())) {
            updateUser.setLastName(userDTO.lastName());
        }
        if (StringFunctions.notNullAndNotEmpty(userDTO.phoneNumber())) {
            updateUser.setPhoneNumber(userDTO.phoneNumber());
        }
        if (StringFunctions.notNullAndNotEmpty(userDTO.email())) {
            updateUser.setEmail(userDTO.email());
        }
        if (StringFunctions.notNullAndNotEmpty(userDTO.username())) {
            updateUser.setUsername(userDTO.username());
        }
        if (StringFunctions.notNullAndNotEmpty(userDTO.password())) {
            updateUser.setPassword(userDTO.password());
        }
        if (Objects.nonNull(userDTO.role())) {
            updateUser.setRole(userDTO.role());
        }


        return userMapper.userToUserResponseDto(userRepository.save(updateUser));
    }

    @Override
    public String deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new NotFoundException("User with Id: " + id + " is not found");
        }
        userRepository.delete(user.get());
        return "User with Id:" + id + " is deleted successfully";
    }
}
