package com.ecomBackEnd.ecomBackEnd.repository;

import com.ecomBackEnd.ecomBackEnd.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}

