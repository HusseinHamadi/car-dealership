package org.example.cardealership.repository;

import org.example.cardealership.model.Customer;
import org.example.cardealership.model.RentalCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalCarRepository extends JpaRepository<RentalCar, Long> {
}
