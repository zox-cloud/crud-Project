package com.example.CRUDD.repository;

import com.example.CRUDD.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface  ProductRepository extends JpaRepository<Product , Long> {

}
