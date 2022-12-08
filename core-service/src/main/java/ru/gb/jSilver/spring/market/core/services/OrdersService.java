package ru.gb.jSilver.spring.market.core.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.jSilver.spring.market.api.CartDto;
import ru.gb.jSilver.spring.market.core.converters.ProductConverter;
import ru.gb.jSilver.spring.market.core.data.Order;
import ru.gb.jSilver.spring.market.core.data.OrderItem;
import ru.gb.jSilver.spring.market.core.integrations.CartServiceIntegration;
import ru.gb.jSilver.spring.market.core.repos.OrderItemRepository;
import ru.gb.jSilver.spring.market.core.repos.OrdersRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrdersService {
    private final OrdersRepository ordersRepository;
    private final OrderItemRepository orderItemRepository;
    private final ProductService productService;

    private final ProductConverter productConverter;
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
//        cartService.clearCurrentCart();
        cartServiceIntegration.clearCart();
    }

    public List<Order> findAll () {
        return ordersRepository.findAll();
    }
}
