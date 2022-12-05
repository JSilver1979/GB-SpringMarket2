package ru.gb.jSilver.SpringMarket.dto;

import ru.gb.jSilver.SpringMarket.data.ProductEntity;

public class ProductDto {
    private Long id;

    private String title;
    private Integer price;

    public ProductDto(ProductEntity productEntity) {
        this.id = productEntity.getId();
        this.title = productEntity.getTitle();
        this.price = productEntity.getPrice();
    }

    public ProductDto() {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
