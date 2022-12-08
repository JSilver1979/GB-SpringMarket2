package ru.gb.jSilver.spring.market.products.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductConfig {
    @Bean
    public RestTemplate productRestTemplate() {
        return new RestTemplate();
    }
}
