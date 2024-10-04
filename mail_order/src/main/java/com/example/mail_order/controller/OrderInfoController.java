package com.example.mail_order.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mail_order.entity.OrderInfoEntity;
import com.example.mail_order.service.OrderInfoService;

@Controller
@RequestMapping("/orders")
public class OrderInfoController {

    @Autowired
    private OrderInfoService orderInfoService;

    @GetMapping
    public String getOrders(Model model) {
        List<OrderInfoEntity> orders = orderInfoService.getAllOrders();
        model.addAttribute("orders", orders);
        return "order_list"; 
    }
    
    @GetMapping("/order/form")
    public String showOrderForm(Model model, @RequestParam(required = false) Integer id) { // 変更
        OrderInfoEntity order = (id != null) ? orderInfoService.getOrderById(id) : new OrderInfoEntity();
        model.addAttribute("order", order);
        return "order_form";
    }

    @GetMapping("/new")
    public String createOrderForm(Model model) {
        model.addAttribute("order", new OrderInfoEntity());
        model.addAttribute("currentDate", new Date());
        return "order_form"; 
    }

    @PostMapping
    public String createOrder(@Valid @ModelAttribute("order") OrderInfoEntity order, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("currentDate", new Date());
            return "order_form"; 
        }
        orderInfoService.saveOrder(order);
        // ログ出力
        System.out.println("Order saved: " + order); 

        return "redirect:/orders";
    }

    @GetMapping("/edit/{id}")
    public String editOrderForm(@PathVariable Integer id, Model model) {
        OrderInfoEntity order = orderInfoService.getOrderById(id);
        if (order == null) {
            // 注文が見つからない場合の処理
            return "redirect:/orders";
        }
        model.addAttribute("order", order);
        return "order_form"; 
    }
  
    @PostMapping("/edit/{id}")
    public String updateOrder(@PathVariable Integer id, @Valid @ModelAttribute("order") OrderInfoEntity order, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("currentDate", new Date());
            return "order_form"; 
        }
        order.setId(id); // 更新する注文のIDをセット
        orderInfoService.saveOrder(order); // 注文を保存
        return "redirect:/orders"; // 注文リストにリダイレクト
    }

   

    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Integer id) {
        orderInfoService.deleteOrder(id);
        return "redirect:/orders";
    }
}
