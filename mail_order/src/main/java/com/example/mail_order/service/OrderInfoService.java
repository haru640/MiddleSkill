package com.example.mail_order.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mail_order.entity.OrderInfoEntity;
import com.example.mail_order.repository.OrderInfoRepository;

@Service
public class OrderInfoService {
    @Autowired
    private OrderInfoRepository orderInfoRepository;

    public List<OrderInfoEntity> findAll() {
        return orderInfoRepository.findAll();
    }

    public OrderInfoEntity save(OrderInfoEntity orderInfo) {
        orderInfo.setOrderDate(new Date()); 
        return orderInfoRepository.save(orderInfo);
    }

    public Map<String, Date[]> calculateOrderDates(List<OrderInfoEntity> orders) {
        Map<String, Date[]> orderDateMap = new HashMap<>();
        Date[] dates = new Date[orders.size()];

        for (int i = 0; i < orders.size(); i++) {
            dates[i] = orders.get(i).getOrderDate();
        }
        orderDateMap.put("orderDates", dates);
        return orderDateMap;
    }
}