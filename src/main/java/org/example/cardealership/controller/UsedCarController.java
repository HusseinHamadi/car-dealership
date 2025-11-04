package org.example.cardealership.controller;


import jakarta.validation.Valid;
import org.example.cardealership.dto.UsedCarCreateDTO;
import org.example.cardealership.dto.UsedCarResponseDTO;
import org.example.cardealership.dto.UsedCarUpdateDTO;
import org.example.cardealership.service.UsedCarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usedcars")
public class UsedCarController {
    UsedCarService usedCarService;

    public UsedCarController(UsedCarService usedCarService){
        this.usedCarService = usedCarService;
    }

    @GetMapping
    public ResponseEntity<List<UsedCarResponseDTO>> getAllUsedCars(){
        List<UsedCarResponseDTO> usedCarList = usedCarService.getAllUsedCars();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(usedCarList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsedCarResponseDTO> getUsedCarById(@PathVariable Long id){
        UsedCarResponseDTO usedCar = usedCarService.getUsedCarById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(usedCar);
    }

    @PostMapping
    public ResponseEntity<UsedCarResponseDTO> addUsedCar(@Valid @RequestBody UsedCarCreateDTO usedCarDTO){
        UsedCarResponseDTO usedCar = usedCarService.addUsedCar(usedCarDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(usedCar);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsedCarResponseDTO> updateUsedCar(@RequestBody UsedCarUpdateDTO usedCarDTO, @PathVariable Long id){
        UsedCarResponseDTO usedCar = usedCarService.updateUsedCar(usedCarDTO, id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(usedCar);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsedCar(@PathVariable Long id){
        String message = usedCarService.deleteUsedCar(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(message);
    }
}
