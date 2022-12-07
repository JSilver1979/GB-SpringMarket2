package ru.gb.jSilver.spring.market.core.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.gb.jSilver.spring.market.core.data.ProductEntity;
import ru.gb.jSilver.spring.market.api.ProductDto;

@Component
@RequiredArgsConstructor
public class ProductConverter {

    public ProductDto entityToDto (ProductEntity product) {
        return new ProductDto(
                product.getId(),
                product.getTitle(),
                product.getPrice()
        );
    }

    public ProductEntity dtoToEntity(ProductDto productDto) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(productDto.getId());
        productEntity.setTitle(productDto.getTitle());
        productEntity.setPrice(productDto.getPrice());

        return productEntity;
    }
}
