package ru.gb.jSilver.spring.market.orders.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.jSilver.spring.market.orders.data.Order;


@Repository
public interface OrdersRepository extends JpaRepository<Order, Long> {

}
