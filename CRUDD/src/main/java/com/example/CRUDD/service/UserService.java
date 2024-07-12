package com.example.CRUDD.service;

import com.example.CRUDD.entity.Users;

import java.util.Optional;

public interface UserService {

    Users saveUser(Users users);
    Optional<Users> findByUsername(String username);



}
