package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.product;

public interface ProductRepo extends JpaRepository<product, Integer> {
}
