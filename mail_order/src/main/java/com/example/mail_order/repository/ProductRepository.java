package com.example.mail_order.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mail_order.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> { // Longに修正

    Optional<ProductEntity> findById(Long id);
}
