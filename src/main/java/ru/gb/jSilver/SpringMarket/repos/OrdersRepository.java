package ru.gb.jSilver.SpringMarket.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.jSilver.SpringMarket.data.Order;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Order, Long> {

}
