package ru.gb.jSilver.spring.market.products.converters;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.gb.jSilver.spring.market.api.ProductDto;
import ru.gb.jSilver.spring.market.products.repos.ProductRepository;

import java.util.Map;
import java.util.Optional;

@Component
@Data
@RequiredArgsConstructor
public class ProductCacheProxy {
    private Map<Long, Optional<ProductDto>> cacheMap;
    private final ProductConverter productConverter;
    private final ProductRepository productRepository;

    public Optional<ProductDto> findById(Long id) {
        if (!cacheMap.containsKey(id)) {
            cacheMap.put(id, productRepository.findById(id).map(productConverter::entityToDto));
        }
        return cacheMap.get(id);
    }
}
