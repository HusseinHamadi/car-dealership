package org.example.cardealership.repository;

import org.example.cardealership.model.NewCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewCarRepository extends JpaRepository<NewCar, Long> {
}
