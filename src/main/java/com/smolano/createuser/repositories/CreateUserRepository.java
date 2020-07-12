package com.smolano.createuser.repositories;

import com.smolano.createuser.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CreateUserRepository extends JpaRepository<User, Long> {
    Optional<User> findByIdentification(String identification);
}
