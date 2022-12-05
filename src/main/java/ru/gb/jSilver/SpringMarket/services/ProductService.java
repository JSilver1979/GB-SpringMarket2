package ru.gb.jSilver.SpringMarket.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.jSilver.SpringMarket.data.ProductEntity;
import ru.gb.jSilver.SpringMarket.dto.*;
import ru.gb.jSilver.SpringMarket.repos.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<ProductDto> findById(Long id) {
        return productRepository.findById(id).map(product -> new ProductDto(product));
    }

    public List<ProductListDto> findAllProducts() {
        List<ProductListDto> productList = (List<ProductListDto>) productRepository.findAll()
                .stream()
                .map(product -> new ProductListDto(product))
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
