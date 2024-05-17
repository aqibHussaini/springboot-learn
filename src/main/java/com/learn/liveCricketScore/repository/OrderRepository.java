package com.learn.liveCricketScore.repository;

import com.learn.liveCricketScore.model.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Orders, Integer> {
}
