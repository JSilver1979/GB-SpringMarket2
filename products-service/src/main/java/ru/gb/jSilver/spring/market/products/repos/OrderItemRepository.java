package ru.gb.jSilver.spring.market.products.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.jSilver.spring.market.products.data.OrderItem;


@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
