package org.example.cardealership.controller;


import jakarta.validation.Valid;
import org.example.cardealership.dto.NewCarCreateDTO;
import org.example.cardealership.dto.NewCarResponseDTO;
import org.example.cardealership.dto.NewCarUpdateDTO;
import org.example.cardealership.service.NewCarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/newcars")
public class NewCarController {

    NewCarService newCarService;

    public NewCarController(NewCarService newCarService){
        this.newCarService = newCarService;
    }

    @GetMapping
    public ResponseEntity<List<NewCarResponseDTO>> getAllNewCars(){
        List<NewCarResponseDTO> newCarList = newCarService.getAllNewCars();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(newCarList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewCarResponseDTO> getNewCarById(@PathVariable Long id){
        NewCarResponseDTO newCar = newCarService.getNewCarById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(newCar);
    }

    @PostMapping
    public ResponseEntity<NewCarResponseDTO> addNewCar(@Valid @RequestBody NewCarCreateDTO newCarDTO){
        NewCarResponseDTO newCar = newCarService.addNewCar(newCarDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(newCar);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NewCarResponseDTO> updateNewCar(@RequestBody NewCarUpdateDTO newCarDTO, @PathVariable Long id){
        NewCarResponseDTO newCar = newCarService.updateNewCar(newCarDTO, id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(newCar);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNewCar(@PathVariable Long id){
        String message = newCarService.deleteNewCar(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(message);
    }
}
