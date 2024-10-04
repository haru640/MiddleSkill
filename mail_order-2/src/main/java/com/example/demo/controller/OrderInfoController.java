	package com.example.demo.controller;
	import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.OrderInfoService;
import com.example.demo.model.OrderInfo;

	@Controller
	@RequestMapping("/orders")
	public class OrderInfoController {
	    @Autowired
	    private OrderInfoService orderInfoService;

	    @GetMapping
	    public String getOrders(Model model) {
	        List<OrderInfo> orders = orderInfoService.getAllOrders();
	        model.addAttribute("orders", orders);
	        return "order_list"; // Thymeleafテンプレート名
	    }

	    @GetMapping("/new")
	    public String createOrderForm(Model model) {
	        model.addAttribute("order", new OrderInfo());
	        return "order_form"; // 新規登録フォーム用テンプレート名
	    }

	    @PostMapping
	    public String createOrder(@Valid @ModelAttribute OrderInfo order, BindingResult bindingResult, Model model) {
	        if (bindingResult.hasErrors()) {
	            return "order_form"; // エラーがあればフォームを再表示
	        }

	        orderInfoService.saveOrder(order);
	        return "redirect:/orders";
	    }

	    // その他のCRUD操作（更新・削除など）
	}



