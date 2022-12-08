package ru.gb.jSilver.spring.market.products.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.jSilver.spring.market.api.*;
import ru.gb.jSilver.spring.market.products.converters.ProductConverter;
import ru.gb.jSilver.spring.market.products.data.ProductEntity;
import ru.gb.jSilver.spring.market.products.repos.ProductRepository;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductConverter productConverter;


    public Optional<ProductDto> findById(Long id) {
        return productRepository.findById(id).map(productConverter::entityToDto);
    }

    public List<ProductDto> findAllProducts() {
        List<ProductDto> productList = productRepository.findAll()
                .stream()
                .map(productConverter::entityToDto)
                .collect(Collectors.toList());
        return productList;
    }


    public void deleteProduct(Long id) {
        DeleteProductDto deleteProductDto = new DeleteProductDto(id);
        productRepository.deleteById(deleteProductDto.getId());
    }

    public void createProduct(CreateProductDto product) {
        productRepository.save(new ProductEntity(product.getTitle(), product.getPrice()));
    }

    @Transactional
    public void changeProductPrice(Long productId, Integer price) {
        ChangeProductPriceDto productChangedPrice = new ChangeProductPriceDto(productId, price);
        ProductEntity productEntity = productRepository.findById(productChangedPrice.getId()).orElseThrow();
        productEntity.setPrice(productEntity.getPrice() + productChangedPrice.getPrice());
        productRepository.save(productEntity);
    }

    @Transactional
    public void updateProduct(UpdateProductDto product) {
        ProductEntity updatedProductEntity = productRepository.findById(product.getId()).orElseThrow();
        updatedProductEntity.setPrice(product.getPrice());
        updatedProductEntity.setTitle(product.getTitle());
        productRepository.save(updatedProductEntity);
    }
}
