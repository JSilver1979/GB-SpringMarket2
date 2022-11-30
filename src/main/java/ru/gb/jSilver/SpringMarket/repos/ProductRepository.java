package ru.gb.jSilver.SpringMarket.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.jSilver.SpringMarket.data.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
