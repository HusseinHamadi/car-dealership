package org.example.cardealership.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="rentals")
public class Rentals {

    @Id
    private Long id;

    private LocalDateTime rentStart;
    private LocalDateTime rentEnd;

    private BigDecimal totalPrice;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Customer customer;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private RentalCar rentalCar;

}
