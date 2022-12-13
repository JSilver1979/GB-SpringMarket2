package ru.gb.jSilver.spring.market.cart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.gb.jSilver.spring.market.api.ProductDto;
import ru.gb.jSilver.spring.market.cart.integrations.ProductServiceIntegration;
import ru.gb.jSilver.spring.market.cart.services.CartService;

@SpringBootTest
public class CartServiceTest {
    @Autowired
    private CartService cartService;

    @MockBean
    private ProductServiceIntegration productServiceIntegration;

    @BeforeEach
    public void initCart() {
        cartService.clearCurrentCart();
    }

    @Test
    public void addToCartTest() {
        ProductDto productDto = new ProductDto(321L, "Coca-Cola", 5000);

        Mockito.doReturn(productDto).when(productServiceIntegration).getProductById(321L);
        cartService.add(321L);
        cartService.add(321L);
        cartService.add(321L);

        Mockito.verify(productServiceIntegration, Mockito
                .times(1))
                .getProductById(ArgumentMatchers.eq(productDto.getId()));
        Assertions.assertEquals(1,cartService.getCurrentCart().getItems().size());

    }
}
