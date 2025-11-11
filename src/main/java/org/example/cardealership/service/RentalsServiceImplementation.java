package org.example.cardealership.service;


import org.example.cardealership.dto.RentalsCreateDTO;
import org.example.cardealership.dto.RentalsResponseDTO;
import org.example.cardealership.dto.RentalsUpdateDTO;
import org.example.cardealership.exception.NotFoundException;
import org.example.cardealership.mapper.RentalsMapper;
import org.example.cardealership.model.Customer;
import org.example.cardealership.model.RentalCar;
import org.example.cardealership.model.Rentals;
import org.example.cardealership.model.User;
import org.example.cardealership.repository.CustomerRepository;
import org.example.cardealership.repository.RentalCarRepository;
import org.example.cardealership.repository.RentalsRepository;
import org.example.cardealership.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.logging.Logger;

@Service
public class RentalsServiceImplementation implements RentalsService {

    private static final Logger logger = Logger.getLogger(RentalsServiceImplementation.class.getName());

    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final RentalCarRepository rentalCarRepository;
    RentalsRepository rentalsRepository;
    RentalsMapper rentalsMapper;

    public RentalsServiceImplementation(RentalsRepository rentalsRepository, RentalsMapper rentalsMapper, UserRepository userRepository, CustomerRepository customerRepository, RentalCarRepository rentalCarRepository) {
        this.rentalsRepository = rentalsRepository;
        this.rentalsMapper = rentalsMapper;
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
        this.rentalCarRepository = rentalCarRepository;
    }

    @Override
    public List<RentalsResponseDTO> getAllRentals() {

        logger.info("Getting all rental records: Rentals Service");

        return rentalsRepository.findAll()
                .stream()
                .map(rentals -> rentalsMapper.rentalsToRentalResponseDto(rentals))
                .toList();
    }

    @Override
    public RentalsResponseDTO getRentalsById(Long id) {

        return rentalsMapper.rentalsToRentalResponseDto(
                rentalsRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException("Rental Record with id: " + id + " is not found."))
        );
    }

    @Override
    public RentalsResponseDTO addRentals(RentalsCreateDTO rentalsDTO) {

        User user  = userRepository.findById(rentalsDTO.userId()).orElseThrow(() -> new NotFoundException("User with Id: " + rentalsDTO.userId() + " is not found."));
        Customer customer = customerRepository.findById(rentalsDTO.customerId()).orElseThrow(() -> new NotFoundException("Customer with Id: " + rentalsDTO.customerId() + " is not found."));
        RentalCar rentalCar = rentalCarRepository.findById(rentalsDTO.rentalCarId()).orElseThrow(() -> new NotFoundException("Rental car with Id: " + rentalsDTO.rentalCarId() + " is not found."));

        Rentals rentalRecord = rentalsMapper.rentalsCreateDtoToRentals(rentalsDTO);

        rentalRecord.setUser(user);
        rentalRecord.setCustomer(customer);
        rentalRecord.setRentalCar(rentalCar);


        long days = ChronoUnit.DAYS.between(rentalsDTO.rentStart(), rentalsDTO.rentEnd());
        BigDecimal price = rentalRecord.getRentalCar().getDailyRate().multiply(BigDecimal.valueOf(days));
        rentalRecord.setTotalPrice(price);

        return rentalsMapper.rentalsToRentalResponseDto(
                rentalsRepository.save(rentalRecord)
        );
    }

    @Override
    public RentalsResponseDTO updateRentals(RentalsUpdateDTO rentalsDTO, Long id) {

        Rentals rentalRecord = rentalsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Rental Record with id: " + id + " is not found."));

        if(rentalsDTO.rentStart()!=null){
            rentalRecord.setRentStart(rentalsDTO.rentStart());
        }
        if(rentalsDTO.rentEnd()!=null){
            rentalRecord.setRentEnd(rentalsDTO.rentEnd());
        }


        long days = ChronoUnit.DAYS.between(rentalRecord.getRentStart(), rentalRecord.getRentEnd());
        BigDecimal price = rentalRecord.getRentalCar().getDailyRate().multiply(BigDecimal.valueOf(days));
        rentalRecord.setTotalPrice(price);

        Rentals updated = rentalsRepository.save(rentalRecord);

        return rentalsMapper.rentalsToRentalResponseDto(updated);
    }

    @Override
    public String deleteRentals(Long id) {
        Rentals rentalRecord = rentalsRepository.findById(id).orElseThrow(()-> new NotFoundException("Rental Record with id: " + id + " is not found."));
        rentalsRepository.delete(rentalRecord);

        return "Rental record with Id: " + id + " is deleted successfully.";

    }
}
