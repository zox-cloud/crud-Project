package com.example.CRUDD.service;

import com.example.CRUDD.entity.Users;
import com.example.CRUDD.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceUsage implements UserService{
    @Autowired
    private UserRepository userRepository;


    @Override
    public Users saveUser(Users users) {
        return userRepository.save(users);
    }

    @Override
    public Optional<Users> findByUsername(String username) {
        return Optional.ofNullable(userRepository.findByUsername(username));
    }
}
