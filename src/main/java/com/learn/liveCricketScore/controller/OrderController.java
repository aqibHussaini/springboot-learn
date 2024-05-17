package com.learn.liveCricketScore.controller;

import com.learn.liveCricketScore.dto.OrderDTO;
import com.learn.liveCricketScore.model.Orders;
import com.learn.liveCricketScore.model.Users;
import com.learn.liveCricketScore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/top3usersbasedonordee")
    private List<Users> getUsersBasedOnMostOrder()
    {
        return orderService.getUsersBasedOnOrder();
    }

    @GetMapping("/order")
    private List<OrderDTO> getAllOrder()
    {
        return orderService.getAllOrders();
    }

    @GetMapping("/order/{orderid}")
    private Orders getOrders(@PathVariable("orderid") int orderid)
    {
        return orderService.getOrdersById(orderid);
    }

    @DeleteMapping("/order/{orderid}")
    private void deleteOrder(@PathVariable("orderid") int orderid)
    {
        orderService.delete(orderid);
    }

    @PostMapping("/orders")
    private String saveOrder(@RequestBody OrderDTO orderDTO)
    {
         orderService.saveOrUpdate(orderDTO);
         return "order Created..";
    }

    @PutMapping("/orders")
    private String update(@RequestBody OrderDTO orderDTO)
    {
        orderService.saveOrUpdate(orderDTO);
        return "order updated..";
    }
}
