package org.example.cardealership.controller;


import jakarta.validation.Valid;
import org.example.cardealership.dto.RentalCarCreateDTO;
import org.example.cardealership.dto.RentalCarResponseDTO;
import org.example.cardealership.dto.RentalCarUpdateDTO;
import org.example.cardealership.service.RentalCarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentalcars")
public class RentalCarController {

    RentalCarService rentalCarService;

    public RentalCarController(RentalCarService rentalCarService){
        this.rentalCarService = rentalCarService;
    }

    @GetMapping
    public ResponseEntity<List<RentalCarResponseDTO>> getAllRentalCars(){
        List<RentalCarResponseDTO> rentalCarList = rentalCarService.getAllRentalCars();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(rentalCarList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentalCarResponseDTO> getRentalCarById(@PathVariable Long id){
        RentalCarResponseDTO rentalCar = rentalCarService.getRentalCarById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(rentalCar);
    }

    @PostMapping
    public ResponseEntity<RentalCarResponseDTO> addRentalCar(@Valid @RequestBody RentalCarCreateDTO rentalCarDTO){
        RentalCarResponseDTO rentalCar = rentalCarService.addRentalCar(rentalCarDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(rentalCar);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RentalCarResponseDTO> updateRentalCar(@RequestBody RentalCarUpdateDTO rentalCarDTO, @PathVariable Long id){
        RentalCarResponseDTO rentalCar = rentalCarService.updateRentalCar(rentalCarDTO, id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(rentalCar);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRentalCar(@PathVariable Long id){
        String message = rentalCarService.deleteRentalCar(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(message);
    }

}
