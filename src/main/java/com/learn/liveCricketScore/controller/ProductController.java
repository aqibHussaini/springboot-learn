package com.learn.liveCricketScore.controller;

import com.learn.liveCricketScore.model.Products;
import com.learn.liveCricketScore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/top3mostordered")
    public List<Products> getTop3MostOrderedProducts() {
        return productService.getTop3MostOrderedProducts();
    }

    @GetMapping("/top3mostreordered")
    public List<Products> getTop3MostReorderedProducts() {
        return productService.getTop3MostReorderedProducts();
    }
}
