package ru.gb.jSilver.spring.market.cart.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CartConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
