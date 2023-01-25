package ru.gb.jSilver.spring.market.orders.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.jSilver.spring.market.api.CartDto;
import ru.gb.jSilver.spring.market.orders.data.Order;
import ru.gb.jSilver.spring.market.orders.data.OrderItem;
import ru.gb.jSilver.spring.market.orders.integrations.CartServiceIntegration;
import ru.gb.jSilver.spring.market.orders.repos.OrderItemRepository;
import ru.gb.jSilver.spring.market.orders.repos.OrdersRepository;


import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrdersService {
    private final OrdersRepository ordersRepository;
    private final OrderItemRepository orderItemRepository;
    private final CartServiceIntegration cartServiceIntegration;


    @Transactional
    public Order createOrder() {
        Order order = new Order();
        CartDto cartDto = cartServiceIntegration.getCartDto();
        order.setTotalPrice(cartDto.getTotalPrice());
        order.setItems(cartDto.getItems().stream().map(
                cartItemDto -> new OrderItem(
                        order,
                        cartItemDto.getId(),
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
        return order;
    }

    public List<Order> findAll () {
        return ordersRepository.findAll();
    }
}
