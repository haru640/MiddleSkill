package com.example.mail_order.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

    // 日付をフォーマットするメソッド
    public String formatDate(Date date) {
        return date != null ? dateFormat.format(date) : "";
    }

    // 日付をパースするメソッド
    public Date parseDate(String dateString) throws ParseException {
        return dateFormat.parse(dateString);
    }

    @GetMapping
    public String getOrders(Model model) {
        List<OrderInfoEntity> orders = orderInfoService.getAllOrders();
        model.addAttribute("orders", orders);
        return "order_list"; 
    }
    
    @GetMapping("/order/form")
    public String showOrderForm(Model model, @RequestParam(required = false) Integer id) {
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
        return "redirect:/orders";
    }

    @GetMapping("/edit/{id}")
    public String editOrderForm(@PathVariable Integer id, Model model) {
        OrderInfoEntity order = orderInfoService.getOrderById(id);
        if (order == null) {
            return "redirect:/orders";
        }
        model.addAttribute("order", order);
        return "order_edit"; 
    }

    @PostMapping("/edit/{id}")
    public String updateOrder(@PathVariable Integer id, @Valid @ModelAttribute("order") OrderInfoEntity order, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            System.out.println("Errors: " + bindingResult.getAllErrors());
            model.addAttribute("currentDate", new Date());
            return "order_edit"; 
        }
        order.setId(id);
        orderInfoService.saveOrder(order);
        return "redirect:/orders"; 
    }

    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Integer id) {
        orderInfoService.deleteOrder(id);
        return "redirect:/orders";
    }
}
