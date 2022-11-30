package ru.gb.jSilver.SpringMarket.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.jSilver.SpringMarket.data.Order;
import ru.gb.jSilver.SpringMarket.data.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
