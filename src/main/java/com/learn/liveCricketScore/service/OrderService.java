package com.learn.liveCricketScore.service;

import com.learn.liveCricketScore.dto.OrderDTO;
import com.learn.liveCricketScore.model.Orders;
import com.learn.liveCricketScore.model.Products;
import com.learn.liveCricketScore.model.Users;
import com.learn.liveCricketScore.repository.OrderRepository;
import com.learn.liveCricketScore.repository.ProductRepository;
import com.learn.liveCricketScore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;


    public List<Users> getUsersBasedOnOrder() {
        return this.userRepository.findTop3UsersByOrderCount(PageRequest.of(0, 3));
    }

    public List<OrderDTO> getAllOrders() {
        Iterable<Orders> orders = orderRepository.findAll();

        List<OrderDTO> orderDTOS = new ArrayList<>();

        orders.forEach(o -> {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setOrderId(o.getOrderId());
            orderDTO.setUserId(o.getUserId().getUserid());
            orderDTO.setProductIds(o.getProductId().stream().map(p -> p.getProductId()).collect(Collectors.toList()));
            orderDTO.setQuantity(o.getQuantity());
            orderDTOS.add(orderDTO);
        });

        return orderDTOS;
    }

    public Orders getOrdersById(int id) {
        return orderRepository.findById(id).get();
    }

    public void saveOrUpdate(OrderDTO orderDTO) {
        orderRepository.save(createOrderObject(orderDTO));
    }

    public void delete(int id) {
        orderRepository.deleteById(id);
    }

    public Orders createOrderObject(OrderDTO orderDTO) {
        Orders order;
        if (orderDTO.getOrderId() == 0) {

            order = new Orders();

        } else {

            order = this.orderRepository.findById(orderDTO.getOrderId()).get();

        }

        order.setOrderDate(new Date());
        order.setQuantity(orderDTO.getQuantity());
        order.setUserId(this.userRepository.findById(orderDTO.getUserId()).get());

        final Double[] totalAmount = {0.0};

        List<Products> products = new ArrayList<>();
        orderDTO.getProductIds().forEach(id -> {
            Products prod = this.productRepository.findById(id).get();
            totalAmount[0] = totalAmount[0] + prod.getPrice() * orderDTO.getQuantity();
            products.add(prod);
        });


        order.setTotalAmount(totalAmount[0]);

        order.setProductId(products);

        return order;
    }
}
