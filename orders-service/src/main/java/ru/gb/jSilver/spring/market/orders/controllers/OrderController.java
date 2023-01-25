package ru.gb.jSilver.spring.market.orders.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.gb.jSilver.spring.market.orders.data.Order;
import ru.gb.jSilver.spring.market.orders.services.OrdersService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrdersService ordersService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder()
    {
        ordersService.createOrder();
    }

    @GetMapping("/get")
    public List<Order> getOrders () {
        return ordersService.findAll();
    }
}
