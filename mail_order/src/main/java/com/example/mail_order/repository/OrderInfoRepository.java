package com.example.mail_order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mail_order.entity.OrderInfoEntity;

public interface OrderInfoRepository extends JpaRepository<OrderInfoEntity, Integer> {}
