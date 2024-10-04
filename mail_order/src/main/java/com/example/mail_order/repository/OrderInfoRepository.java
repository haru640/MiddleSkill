// OrderInfoRepository.java
package com.example.mail_order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mail_order.entity.OrderInfoEntity;

public interface OrderInfoRepository extends JpaRepository<OrderInfoEntity, Integer> {
    List<OrderInfoEntity> findByName(String name); // ここで正しいプロパティを使用
}
