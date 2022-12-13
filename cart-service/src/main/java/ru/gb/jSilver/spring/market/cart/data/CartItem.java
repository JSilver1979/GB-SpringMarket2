package ru.gb.jSilver.spring.market.cart.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    private Long id;
    private String productTitle;
    private Integer quantity;
    private Integer pricePerProduct;
    private Integer price;
}
