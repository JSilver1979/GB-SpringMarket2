package ru.gb.jSilver.SpringMarket.dto;

public class ChangeProductPriceDto {

    private Long id;
    private Integer price;

    public ChangeProductPriceDto(Long id, Integer price) {
        this.id = id;
        this.price = price;
    }

    public ChangeProductPriceDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
