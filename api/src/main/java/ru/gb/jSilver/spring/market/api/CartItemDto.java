package ru.gb.jSilver.spring.market.api;

public class CartItemDto {
    private Long id;
    private String productTitle;
    private Integer quantity;
    private Integer pricePerProduct;
    private Integer price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPricePerProduct() {
        return pricePerProduct;
    }

    public void setPricePerProduct(Integer pricePerProduct) {
        this.pricePerProduct = pricePerProduct;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
