package com.example.mail_order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mail_order.entity.ProductEntity;
import com.example.mail_order.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/detail/{id}")
    public String viewProductDetail(@PathVariable("id") Long id, Model model) {
        ProductEntity product = productService.findById(id);
        model.addAttribute("product", product);
        return "product/detail"; // テンプレート名
    }
}
