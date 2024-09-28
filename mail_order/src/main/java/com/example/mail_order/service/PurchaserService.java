package com.example.mail_order.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mail_order.entity.PurchaserEntity;
import com.example.mail_order.repository.PurchaserRepository;

@Service
public class PurchaserService {
    @Autowired
    private PurchaserRepository purchaserRepository;

    public List<PurchaserEntity> findAll() {
        return purchaserRepository.findAll();
    }

    public PurchaserEntity save(@Valid PurchaserEntity purchaser) {
        return purchaserRepository.save(purchaser);
    }
}
