package org.example.cardealership.repository;

import org.example.cardealership.model.Customer;
import org.example.cardealership.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {
}
