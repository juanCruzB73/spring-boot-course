package com.security.springSecurity.repository;

import com.security.springSecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<com.security.springSecurity.model.User>findByUsername(String username);

}
