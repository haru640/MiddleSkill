package com.example.mail_order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mail_order.entity.ProductEntity;
import com.example.mail_order.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    // 全商品を取得するメソッド
    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }

    // 商品を保存するメソッド
    public ProductEntity save(ProductEntity product) {
        return productRepository.save(product);
    }

    // 商品IDで特定の商品を取得するメソッド
    public ProductEntity findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
