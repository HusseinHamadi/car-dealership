package org.example.cardealership.model;


import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


//superBuilder for inheritance
//not using Data for equals and stack overflow relationship comarison
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@PrimaryKeyJoinColumn(name="sale_car_id")
@Table(name = "used_cars")
public class UsedCar extends SaleCar{

    private Long mileage;


}
