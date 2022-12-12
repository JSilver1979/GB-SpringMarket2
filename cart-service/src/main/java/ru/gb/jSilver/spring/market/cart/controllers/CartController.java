package ru.gb.jSilver.spring.market.cart.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.jSilver.spring.market.api.CartDto;
import ru.gb.jSilver.spring.market.cart.services.CartService;


@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping("/add/{id}")
    public void addToCart(@PathVariable Long id) {
        cartService.add(id);
    }

    @GetMapping
    public CartDto getCurrentCart() {
        return cartService.getCurrentCart();
    }

    @GetMapping("/clear")
    public void clearCart() {
        cartService.clearCurrentCart();
    }
}
