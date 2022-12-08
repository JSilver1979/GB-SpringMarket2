package ru.gb.jSilver.spring.market.core.integrations;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.gb.jSilver.spring.market.api.CartDto;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CartServiceIntegration {
    private final RestTemplate restTemplate;

    public CartDto getCartDto() {
        return Optional.ofNullable(restTemplate.getForObject("http://localhost:8190/market-cart/api/v1/cart", CartDto.class)).orElseThrow();
    }

    public void clearCart() {
        restTemplate.getForObject("http://localhost:8190/market-cart/api/v1/cart/clear",CartDto.class);
    }
}
