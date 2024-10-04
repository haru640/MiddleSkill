package com.example.demo.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.OrderInfo;
import com.example.demo.repository.OrderInfoRepository;

@Service
public class OrderInfoService {
    @Autowired
    private OrderInfoRepository repository;

    public List<OrderInfo> getAllOrders() {
        return repository.findAll();
    }

    public void saveOrder(OrderInfo order) {
        repository.save(order);
    }

    public void deleteOrder(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            // エラーハンドリング
        }
    }

    @Transactional
    public Map<String, Integer> getProductCountByCategory() {
        // ここに実際のデータ取得ロジックを実装
        Map<String, Integer> productCount = new HashMap<>();
        // 仮のデータは省略
        return productCount;
    }
}
