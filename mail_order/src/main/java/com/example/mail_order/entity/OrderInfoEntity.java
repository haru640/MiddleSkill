package com.example.mail_order.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "order_info")
public class OrderInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @ManyToOne
    @JoinColumn(name = "purchaser_id")
    private PurchaserEntity purchaser;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @Temporal(TemporalType.TIMESTAMP) // 日付のタイプを指定
    private Date orderDate; // orderDateフィールドを追加

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public PurchaserEntity getPurchaser() {
        return purchaser;
    }

    public void setPurchaser(PurchaserEntity purchaser) {
        this.purchaser = purchaser;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public Date getOrderDate() { // 正しいゲッターの実装
        return orderDate;
    }

    public void setOrderDate(Date orderDate) { // 正しいセッターの実装
        this.orderDate = orderDate;
    }
}


