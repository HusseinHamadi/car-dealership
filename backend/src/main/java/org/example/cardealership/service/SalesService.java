package org.example.cardealership.service;


import jakarta.validation.Valid;
import org.example.cardealership.dto.SalesCreateDTO;
import org.example.cardealership.dto.SalesResponseDTO;
import org.example.cardealership.dto.SalesUpdateDTO;

import java.util.List;

public interface SalesService {
    List<SalesResponseDTO> getAllSales();

    SalesResponseDTO getSalesById(Long id);

    SalesResponseDTO addSales(@Valid SalesCreateDTO salesDTO);

    SalesResponseDTO updateSales(SalesUpdateDTO salesDTO, Long id);

    String deleteSales(Long id);
}
