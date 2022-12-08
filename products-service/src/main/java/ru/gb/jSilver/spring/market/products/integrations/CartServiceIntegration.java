package ru.gb.jSilver.spring.market.products.integrations;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.gb.jSilver.spring.market.api.CartDto;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CartServiceIntegration {
    private final RestTemplate restTemplate;

    @Value(value = "${cart.get-cart}")
    private String getCartUrl;

    @Value(value = "${cart.clear-cart}")
    private String clearCartUrl;

    public CartDto getCartDto() {
        return Optional.ofNullable(restTemplate.getForObject(getCartUrl, CartDto.class)).orElseThrow();
    }

    public void clearCart() {
        restTemplate.getForObject(clearCartUrl,CartDto.class);
    }
}
