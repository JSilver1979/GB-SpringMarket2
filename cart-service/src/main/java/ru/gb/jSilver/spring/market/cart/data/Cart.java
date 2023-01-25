package ru.gb.jSilver.spring.market.cart.data;

import lombok.Data;
import ru.gb.jSilver.spring.market.api.ProductDto;

import java.util.*;
import java.util.stream.Collectors;

@Data
public class Cart {
    private List<CartItem> cartItems;
    private Map<Long, CartItem> mapCartItems;
    private Integer totalPrice;

    public Cart() {
        this.cartItems = new ArrayList<>();
        this.mapCartItems = new HashMap<>();
    }

    public List<CartItem> getItems() {
        return cartItems;
    }

    public void addNewItem(ProductDto productDto) {
        if(!mapCartItems.containsKey(productDto.getId())) {
            mapCartItems.put(productDto.getId(), new CartItem(
                    productDto.getId(),
                    productDto.getTitle(),
                    1,
                    productDto.getPrice(),
                    productDto.getPrice()
            ));
        }
        cartItems = mapCartItems.values().stream().collect(Collectors.toList());
        recalculate();
    }

    public void addExistingItem(Long id) {
        CartItem existingCartItem = mapCartItems.get(id);
        existingCartItem.setQuantity(existingCartItem.getQuantity() + 1);
        existingCartItem.setPrice(existingCartItem.getPrice() + existingCartItem.getPricePerProduct());

        cartItems = mapCartItems.values().stream().collect(Collectors.toList());
        recalculate();
    }

    private void recalculate () {
        totalPrice = 0;
        for (CartItem item:
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
