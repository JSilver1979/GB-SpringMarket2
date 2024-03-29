package ru.gb.jSilver.spring.market.cart.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.jSilver.spring.market.api.CartDto;
import ru.gb.jSilver.spring.market.api.ProductDto;
import ru.gb.jSilver.spring.market.cart.converters.CartConverter;
import ru.gb.jSilver.spring.market.cart.data.Cart;
import ru.gb.jSilver.spring.market.cart.integrations.ProductServiceIntegration;


import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class CartService {
    private final ProductServiceIntegration productServiceIntegration;
    private final CartConverter cartConverter;
    private Cart demoCart;

    @PostConstruct
    public void init() {
        demoCart = new Cart();
    }

    public CartDto getCurrentCart() {
        return cartConverter.entityToDto(demoCart);
    }

    public void add(Long id) {
        if (demoCart.getMapCartItems().containsKey(id)) {
            demoCart.addExistingItem(id);
            return;
        }
        ProductDto productDto = productServiceIntegration.getProductById(id);
        demoCart.addNewItem(productDto);

    }

    public void clearCurrentCart() {
        demoCart.clear();
    }
}
