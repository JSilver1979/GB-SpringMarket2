package ru.gb.jSilver.SpringMarket.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.jSilver.SpringMarket.dto.Cart;
import ru.gb.jSilver.SpringMarket.dto.ProductDto;
import ru.gb.jSilver.SpringMarket.exceptions.ResourceNotFoundException;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class CartService {
    private final ProductService productService;
    private Cart demoCart;

    @PostConstruct
    public void init() {
        demoCart = new Cart();
    }

    public Cart getCurrentCart() {
        return demoCart;
    }

    public void add(Long id) {
        ProductDto productDto = productService.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Cannot add to cart product with id: " + id + ". Product not found"));
        demoCart.add(productDto);
    }

    public void clearCurrentCart() {
        demoCart.clear();
    }
}
