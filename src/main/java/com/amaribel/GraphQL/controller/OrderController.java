package com.amaribel.GraphQL.controller;

import com.amaribel.GraphQL.model.Order;
import com.amaribel.GraphQL.service.OrderService;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.util.List;

@Controller
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @QueryMapping
    public List<Order> findAllOrders(Principal principal) {
        return orderService.findAllByUsername(principal.getName());
    }
}
