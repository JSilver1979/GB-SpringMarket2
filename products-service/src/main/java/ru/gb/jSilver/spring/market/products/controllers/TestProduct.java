package ru.gb.jSilver.spring.market.products.controllers;

import org.springframework.stereotype.Component;
import ru.gb.jSilver.spring.market.api.ProductDto;
@Component
public class TestProduct {

    public ProductDto getTestProduct() {
        ProductDto productDto = new ProductDto();
        productDto.setId(777L);
        productDto.setTitle("Coffee");
        productDto.setPrice(180);

        return productDto;
    }

}
