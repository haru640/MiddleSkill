package com.example.mail_order.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mail_order.entity.OrderInfoEntity;
import com.example.mail_order.repository.OrderInfoRepository;

@Service
public class OrderInfoService {
    @Autowired
    private OrderInfoRepository orderInfoRepository;

    public List<OrderInfoEntity> getAllOrders() {
        return orderInfoRepository.findAll();
    }
    @Transactional
    public void saveOrder(OrderInfoEntity order) {
        if (order.getId() != null) {
            System.out.println("Updating order with ID: " + order.getId());
            orderInfoRepository.save(order);
        } else {
            System.out.println("Creating new order");
            orderInfoRepository.save(order);
        }
    }


    public void deleteOrder(Integer id) {
        if (orderInfoRepository.existsById(id)) {
            orderInfoRepository.deleteById(id);
            // ログ追加
            System.out.println("Order with ID " + id + " deleted.");
        } else {
            // エラーハンドリング
            throw new IllegalArgumentException("Order not found with ID: " + id);
        }
    }

    @Transactional
    public Map<String, Integer> getProductCountByCategory() {
        Map<String, Integer> productCount = new HashMap<>();
        // 実際のデータ取得ロジックを実装
        return productCount;
    }

    public OrderInfoEntity getOrderById(Integer id) {
        return orderInfoRepository.findById(id).orElse(null);
    }
}
