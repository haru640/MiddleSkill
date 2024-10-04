package com.example.mail_order.request;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OrderUpdateRequest {

    private Integer id; // 注文ID

    @NotNull(message = "名前は必須です。")
    @Size(min = 1, max = 100, message = "名前は1文字以上100文字以下で入力してください。")
    private String name; // 名前

    private LocalDate deliveryDate; // 配送日

    private String address; // 住所

    @NotNull(message = "注文IDは必須です。")
    private Integer orderId; // 注文ID

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
