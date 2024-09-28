// OrderInfoController.java
package com.example.mail_order.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mail_order.entity.OrderInfoEntity;
import com.example.mail_order.service.OrderInfoService;

@Controller
@RequestMapping("/order_info")
public class OrderInfoController {
    @Autowired
    private OrderInfoService orderInfoService;

    @GetMapping("/list")
    public String listOrders(Model model) {
        model.addAttribute("orders", orderInfoService.findAll());
        return "order/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("order", new OrderInfoEntity());
        return "order/add";
    }

    @PostMapping("/add")
    public String addOrder(@Valid @ModelAttribute("order") OrderInfoEntity orderInfo, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "order/add";
        }
        orderInfoService.save(orderInfo);
        return "redirect:/order_info/list";
    }
}
