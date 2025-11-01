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
    private Long id;

    private LocalDateTime saleDate;
    private BigDecimal finalPrice;

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
    private SaleCar saleCar;

}
