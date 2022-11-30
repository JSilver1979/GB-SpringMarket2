package ru.gb.jSilver.SpringMarket.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.jSilver.SpringMarket.data.Order;
import ru.gb.jSilver.SpringMarket.data.OrderItem;
import ru.gb.jSilver.SpringMarket.dto.Cart;
import ru.gb.jSilver.SpringMarket.repos.OrderItemRepository;
import ru.gb.jSilver.SpringMarket.repos.OrdersRepository;
import ru.gb.jSilver.SpringMarket.repos.ProductRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrdersService {
    private final OrdersRepository ordersRepository;
    private final ProductRepository productRepository;
    private final OrderItemRepository orderItemRepository;
    private final CartService cartService;


    @Transactional
    public void createOrder() {
        Order order = new Order();
        order.setTotalPrice(cartService.getCurrentCart().getTotalPrice());
        order.setItems(cartService.getCurrentCart().getItems().stream().map(
                cartItemDto -> new OrderItem(
                        order,
                        productRepository.findById(cartItemDto.getId()).get(),
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
