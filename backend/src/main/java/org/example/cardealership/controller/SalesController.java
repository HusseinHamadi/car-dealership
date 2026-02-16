package org.example.cardealership.controller;


import jakarta.validation.Valid;
import org.example.cardealership.dto.SalesCreateDTO;
import org.example.cardealership.dto.SalesResponseDTO;
import org.example.cardealership.dto.SalesUpdateDTO;
import org.example.cardealership.service.SalesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/sales")
public class SalesController {
    private static final Logger logger = Logger.getLogger(SalesController.class.getName());

    SalesService salesService;

    public SalesController(SalesService salesService) {

        this.salesService = salesService;
    }

    @GetMapping
    public ResponseEntity<List<SalesResponseDTO>> getAllSales() {
        logger.info("Getting all rental records: Sales Controller");
        List<SalesResponseDTO> salesList = salesService.getAllSales();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(salesList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalesResponseDTO> getSalesById(@PathVariable Long id) {
        SalesResponseDTO sales = salesService.getSalesById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(sales);
    }

    @PostMapping
    public ResponseEntity<SalesResponseDTO> addSales(@Valid @RequestBody SalesCreateDTO salesDTO) {
        SalesResponseDTO sales = salesService.addSales(salesDTO);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(sales);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalesResponseDTO> updateSales(@RequestBody SalesUpdateDTO salesDTO, @PathVariable Long id) {
        SalesResponseDTO sales = salesService.updateSales(salesDTO, id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(sales);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSales(@PathVariable Long id) {
        String message = salesService.deleteSales(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(message);
    }

}
