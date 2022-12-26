package ru.gb.jSilver.spring.market.orders;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.gb.jSilver.spring.market.api.CartDto;
import ru.gb.jSilver.spring.market.api.CartItemDto;
import ru.gb.jSilver.spring.market.api.ProductDto;
import ru.gb.jSilver.spring.market.orders.data.Order;
import ru.gb.jSilver.spring.market.orders.integrations.CartServiceIntegration;
import ru.gb.jSilver.spring.market.orders.repos.OrderItemRepository;
import ru.gb.jSilver.spring.market.orders.repos.OrdersRepository;
import ru.gb.jSilver.spring.market.orders.services.OrdersService;


import java.util.List;
import java.util.Optional;

@SpringBootTest
public class OrderServiceTest {
    @Autowired
    OrdersService ordersService;

    @MockBean
    private CartServiceIntegration cartServiceIntegration;

    @MockBean
    private OrderItemRepository orderItemRepository;
    @MockBean
    private OrdersRepository ordersRepository;

    @Test
    public void createOrderTest() {
        CartItemDto cartItemDto = new CartItemDto();
        cartItemDto.setId(999L);
        cartItemDto.setProductTitle("Coca-Cola");
        cartItemDto.setPricePerProduct(100);
        cartItemDto.setQuantity(2);
        cartItemDto.setPrice(200);

        CartDto testCart = new CartDto();
        testCart.setItems(List.of(cartItemDto));
        testCart.setTotalPrice(200);

        ProductDto productDto = new ProductDto(999L,"Coca-Cola",100);

        Mockito.doReturn(testCart).when(cartServiceIntegration).getCartDto();

        Order testOrder = ordersService.createOrder();
        Assertions.assertEquals(200, testOrder.getTotalPrice());
    }
}
