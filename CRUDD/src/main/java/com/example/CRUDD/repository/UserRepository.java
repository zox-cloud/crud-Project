package com.example.CRUDD.repository;

import com.example.CRUDD.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<Users, Long> {

    Users findByUsername(String username);
}
