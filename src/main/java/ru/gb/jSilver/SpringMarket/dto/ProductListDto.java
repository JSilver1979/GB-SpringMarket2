package ru.gb.jSilver.SpringMarket.dto;

import ru.gb.jSilver.SpringMarket.data.Product;

public class ProductListDto {
    private Long id;
    private String title;
    private Integer price;

    public ProductListDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
    }



    public ProductListDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
