package ru.gb.jSilver.spring.market.products.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.jSilver.spring.market.api.CartDto;
import ru.gb.jSilver.spring.market.products.converters.ProductConverter;
import ru.gb.jSilver.spring.market.products.integrations.CartServiceIntegration;
import ru.gb.jSilver.spring.market.products.repos.OrderItemRepository;
import ru.gb.jSilver.spring.market.products.repos.OrdersRepository;
import ru.gb.jSilver.spring.market.products.data.Order;
import ru.gb.jSilver.spring.market.products.data.OrderItem;


import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrdersService {
    private final OrdersRepository ordersRepository;
    private final OrderItemRepository orderItemRepository;

    private final ProductConverter productConverter;
    private final ProductService productService;

    private final CartServiceIntegration cartServiceIntegration;


    @Transactional
    public void createOrder() {
        Order order = new Order();
        CartDto cartDto = cartServiceIntegration.getCartDto();
        order.setTotalPrice(cartDto.getTotalPrice());
        order.setItems(cartDto.getItems().stream().map(
                cartItemDto -> new OrderItem(
                        order,
                        productConverter.dtoToEntity(productService.findById(cartItemDto.getId()).orElseThrow()),
                        cartItemDto.getQuantity(),
                        cartItemDto.getPricePerProduct(),
                        cartItemDto.getPrice()
                )
        ).collect(Collectors.toList()));
        for (OrderItem item: order.getItems()) {
            orderItemRepository.save(item);
        }

        ordersRepository.save(order);
        cartServiceIntegration.clearCart();
    }

    public List<Order> findAll () {
        return ordersRepository.findAll();
    }
}
