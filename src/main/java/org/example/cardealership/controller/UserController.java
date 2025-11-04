package org.example.cardealership.controller;


import jakarta.validation.Valid;
import org.example.cardealership.dto.UserCreateDTO;
import org.example.cardealership.dto.UserResponseDTO;
import org.example.cardealership.dto.UserUpdateDTO;
import org.example.cardealership.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers(){
        List<UserResponseDTO> users = userService.getAllUsers();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id){
        UserResponseDTO user = userService.getUserById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(user);
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> addUser(@Valid @RequestBody UserCreateDTO user){
        UserResponseDTO createdUser = userService.addUser(user);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@RequestBody UserUpdateDTO user, @PathVariable Long id){
        UserResponseDTO updatedUser = userService.updateUser(user, id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        String message = userService.deleteUser(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(message);
    }


}
