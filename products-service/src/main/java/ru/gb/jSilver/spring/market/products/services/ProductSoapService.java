package ru.gb.jSilver.spring.market.products.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.jSilver.spring.market.products.data.ProductEntity;
import ru.gb.jSilver.spring.market.products.repos.ProductRepository;
import ru.gb.jSilver.spring.market.products.soap.Product;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductSoapService {
    private final ProductRepository productRepository;

    public static final Function<ProductEntity, Product> functionEntityToSoap = productEntity -> {
        Product product = new Product();
        product.setId(productEntity.getId());
        product.setTitle(productEntity.getTitle());
        product.setPrice(productEntity.getPrice());
        return product;
    };

    public List<Product> getSoapProducts() {
        return productRepository.findAll().stream()
                .map(functionEntityToSoap).collect(Collectors.toList());
    }
}
