package ru.gb.jSilver.SpringMarket.dto;

import ru.gb.jSilver.SpringMarket.data.Product;

public class CreateProductDto {

    String title;

    Integer price;

    public CreateProductDto(String title, Integer price) {
        this.title = title;
        this.price = price;
    }

    public CreateProductDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
