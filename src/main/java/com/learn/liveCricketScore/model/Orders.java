package com.learn.liveCricketScore.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Orders {
    @Id
    @Column
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    int orderId;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "date")
    private Date orderDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    Users userId;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "order_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    List<Products> productId;
    Long quantity;
    Double totalAmount ;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public List<Products> getProductId() {
        return productId;
    }

    public void setProductId(List<Products> productId) {
        this.productId = productId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Orders() {
    }
}
