package ru.gb.jSilver.SpringMarket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDto {
    private Long id;
    private String productTitle;
    private Integer quantity;
    private Integer pricePerProduct;
    private Integer price;
}
