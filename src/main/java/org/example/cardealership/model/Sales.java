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
@Table(name = "sales")
public class Sales {

    @Id
    protected Long id;

    protected LocalDateTime saleDate;
    protected BigDecimal finalPrice;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    protected LocalDateTime createdAt;

    @LastModifiedDate
    protected LocalDateTime updatedAt;

    @ManyToOne(cascade = CascadeType.PERSIST)
    protected User user;

    @ManyToOne(cascade = CascadeType.PERSIST)
    protected Customer customer;

    @ManyToOne(cascade = CascadeType.PERSIST)
    protected SaleCar saleCar;

}
