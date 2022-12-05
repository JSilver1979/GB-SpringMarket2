package ru.gb.jSilver.SpringMarket.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.jSilver.SpringMarket.data.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
