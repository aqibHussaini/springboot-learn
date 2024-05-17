package com.learn.liveCricketScore.repository;

import com.learn.liveCricketScore.model.Orders;
import com.learn.liveCricketScore.model.Products;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Products, Integer> {
    @Query("SELECT p FROM Products p JOIN p.orders o GROUP BY p ORDER BY COUNT(o) DESC")
    List<Products> findTop3MostOrderedProducts(Pageable pageable);

    @Query("SELECT p FROM Products p JOIN p.orders o WHERE o.orderDate > " +
            "(SELECT MIN(o2.orderDate) FROM Orders o2 WHERE o2.userId = o.userId) " +
            "GROUP BY p ORDER BY COUNT(o) DESC")
    List<Products> findTop3MostReorderedProducts(Pageable pageable);
}
