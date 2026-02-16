package org.example.cardealership.repository;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.example.cardealership.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(@NotBlank(message = "Username is required.") String username);

    Optional<User> findByEmail(@NotBlank(message = "Email is required.") @Email(message = "Email must be valid.") String email);
}
