package ru.gb.jSilver.spring.market.core.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.jSilver.spring.market.core.data.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
