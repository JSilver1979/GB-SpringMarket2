package ru.gb.jSilver.SpringMarket.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.jSilver.SpringMarket.dto.CreateProductDto;
import ru.gb.jSilver.SpringMarket.dto.ProductDto;
import ru.gb.jSilver.SpringMarket.dto.ProductListDto;
import ru.gb.jSilver.SpringMarket.dto.UpdateProductDto;
import ru.gb.jSilver.SpringMarket.exceptions.ResourceNotFoundException;
import ru.gb.jSilver.SpringMarket.services.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping()
    public List<ProductListDto> getProducts() {
        return productService.findAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        return productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found, id: " + id));
    }

    @PutMapping("/update")
    public void updateProduct(@RequestBody UpdateProductDto product) {
        productService.updateProduct(product);
    }

    @GetMapping ("/change_price")
    public void changeProductPrice(@RequestParam Long productId, @RequestParam Integer price) {
        productService.changeProductPrice(productId, price);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @PostMapping()
    public void addProduct(@RequestBody CreateProductDto product) {
        productService.createProduct(product);
    }
}
