package org.example.cardealership.controller;


import jakarta.validation.Valid;
import org.example.cardealership.dto.RentalsCreateDTO;
import org.example.cardealership.dto.RentalsResponseDTO;
import org.example.cardealership.dto.RentalsUpdateDTO;
import org.example.cardealership.service.RentalsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/rentals")
public class RentalsController {

    private static final Logger logger = Logger.getLogger(RentalsController.class.getName());

    RentalsService rentalsService;

    public RentalsController(RentalsService rentalsService) {

        this.rentalsService = rentalsService;
    }

    @GetMapping
    public ResponseEntity<List<RentalsResponseDTO>> getAllRentals() {
        logger.info("Getting all rental records: Rentals Controller");
        List<RentalsResponseDTO> rentalsList = rentalsService.getAllRentals();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(rentalsList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentalsResponseDTO> getRentalsById(@PathVariable Long id) {
        RentalsResponseDTO rentals = rentalsService.getRentalsById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(rentals);
    }

    @PostMapping
    public ResponseEntity<RentalsResponseDTO> addRentals(@Valid @RequestBody RentalsCreateDTO rentalsDTO) {
        RentalsResponseDTO rentals = rentalsService.addRentals(rentalsDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(rentals);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RentalsResponseDTO> updateRentals(@RequestBody RentalsUpdateDTO rentalsDTO, @PathVariable Long id) {
        RentalsResponseDTO rentals = rentalsService.updateRentals(rentalsDTO, id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(rentals);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRentals(@PathVariable Long id) {
        String message = rentalsService.deleteRentals(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(message);
    }

}
