package ru.gb.jSilver.spring.market.core.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.jSilver.spring.market.core.data.Order;
import ru.gb.jSilver.spring.market.core.data.OrderItem;
import ru.gb.jSilver.spring.market.core.repos.OrderItemRepository;
import ru.gb.jSilver.spring.market.core.repos.OrdersRepository;
import ru.gb.jSilver.spring.market.core.repos.ProductRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrdersService {
    private final OrdersRepository ordersRepository;
    private final OrderItemRepository orderItemRepository;

    private final ProductService productService;
    private final CartService cartService;


    @Transactional
    public void createOrder() {
        Order order = new Order();
        order.setTotalPrice(cartService.getCurrentCart().getTotalPrice());
        order.setItems(cartService.getCurrentCart().getItems().stream().map(
                cartItemDto -> new OrderItem(
                        order,
                        productService.findById(cartItemDto.getId()),
                        cartItemDto.getQuantity(),
                        cartItemDto.getPricePerProduct(),
                        cartItemDto.getPrice()
                )
        ).collect(Collectors.toList()));
        for (OrderItem item: order.getItems()) {
            orderItemRepository.save(item);
        }

        ordersRepository.save(order);
        cartService.clearCurrentCart();
    }

    public List<Order> findAll () {
        return ordersRepository.findAll();
    }
}
