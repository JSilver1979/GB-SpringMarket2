package ru.gb.jSilver.SpringMarket.dto;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

@Data
public class Cart {
    private List<CartItemDto> cartItems;
    private Map<Long,CartItemDto> mapCartItems;
    private Integer totalPrice;

    public Cart() {
        this.cartItems = new ArrayList<>();
        this.mapCartItems = new HashMap<>();
    }

    public List<CartItemDto> getItems() {
        return cartItems;
    }

    public void add(ProductDto productDto) {
        if(!mapCartItems.containsKey(productDto.getId())) {
            mapCartItems.put(productDto.getId(), new CartItemDto(
                    productDto.getId(),
                    productDto.getTitle(),
                    1,
                    productDto.getPrice(),
                    productDto.getPrice()
            ));
        } else {
            CartItemDto existingCartItem = mapCartItems.get(productDto.getId());
            existingCartItem.setQuantity(existingCartItem.getQuantity() + 1);
            existingCartItem.setPrice(existingCartItem.getPrice() + existingCartItem.getPricePerProduct());
        }
        cartItems = mapCartItems.values().stream().collect(Collectors.toList());
        recalculate();
    }

    private void recalculate () {
        totalPrice = 0;
        for (CartItemDto item:
             cartItems) {
            totalPrice += item.getPrice();
        }
    }
    public void clear() {
        cartItems.clear();
        mapCartItems.clear();
        totalPrice = 0;
    }
}
