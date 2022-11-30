package ru.gb.jSilver.SpringMarket.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.gb.jSilver.SpringMarket.data.Order;
import ru.gb.jSilver.SpringMarket.services.OrdersService;

import java.security.Principal;
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

    @GetMapping
    public List<Order> getOrders () {
        return ordersService.findAll();
    }
}
