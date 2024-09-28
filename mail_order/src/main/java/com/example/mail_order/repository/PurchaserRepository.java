package com.example.mail_order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mail_order.entity.PurchaserEntity;

public interface PurchaserRepository extends JpaRepository<PurchaserEntity, Integer> {}
