package com.learn.liveCricketScore.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Products {
     @Id
     @Column
     @GeneratedValue(
             strategy = GenerationType.IDENTITY
     )
     int productId;
     @Column
     String  productName;
     @Column
     Long price;
    @Column
    String  Description;
    @ManyToMany(mappedBy = "productId")
    private List<Orders> orders;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Products() {
    }
}
