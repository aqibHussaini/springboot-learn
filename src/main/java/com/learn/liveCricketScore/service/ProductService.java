package com.learn.liveCricketScore.service;

import com.learn.liveCricketScore.model.Products;
import com.learn.liveCricketScore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Products> getTop3MostOrderedProducts() {
        return productRepository.findTop3MostOrderedProducts(PageRequest.of(0, 3));
    }

    public List<Products> getTop3MostReorderedProducts() {
        return productRepository.findTop3MostReorderedProducts(PageRequest.of(0, 3));
    }
}
