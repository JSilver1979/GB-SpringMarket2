package ru.gb.jSilver.spring.market.products;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.gb.jSilver.spring.market.api.CartDto;
import ru.gb.jSilver.spring.market.api.CartItemDto;
import ru.gb.jSilver.spring.market.api.ProductDto;
import ru.gb.jSilver.spring.market.products.converters.ProductConverter;
import ru.gb.jSilver.spring.market.products.data.Order;
import ru.gb.jSilver.spring.market.products.data.ProductEntity;
import ru.gb.jSilver.spring.market.products.integrations.CartServiceIntegration;
import ru.gb.jSilver.spring.market.products.repos.OrderItemRepository;
import ru.gb.jSilver.spring.market.products.repos.OrdersRepository;
import ru.gb.jSilver.spring.market.products.services.OrdersService;
import ru.gb.jSilver.spring.market.products.services.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class OrderServiceTest {
    @Autowired
    OrdersService ordersService;

    @MockBean
    private CartServiceIntegration cartServiceIntegration;
    @MockBean
    private ProductService productService;

    @MockBean
    ProductConverter productConverter;
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

        ProductEntity product = new ProductEntity();
        product.setId(999L);
        product.setTitle("Coca-Cola");
        product.setPrice(100);


        Mockito.doReturn(product).when(productConverter).dtoToEntity(productDto);
        Mockito.doReturn(Optional.of(productDto)).when(productService).findById(999L);
        Mockito.doReturn(testCart).when(cartServiceIntegration).getCartDto();

        Order testOrder = ordersService.createOrder();
        Assertions.assertEquals(200, testOrder.getTotalPrice());
    }
}
