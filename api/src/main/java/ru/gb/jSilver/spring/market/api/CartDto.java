package ru.gb.jSilver.spring.market.api;

import java.util.List;

public class CartDto {
    private List<CartItemDto> items;
    private Integer totalPrice;

    public List<CartItemDto> getItems() {
        return items;
    }

    public void setItems(List<CartItemDto> items) {
        this.items = items;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }
}
