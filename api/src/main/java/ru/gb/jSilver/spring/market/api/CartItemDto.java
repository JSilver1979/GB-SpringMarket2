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

    public static final class CartItemBuilder {
        private Long id;
        private String productTitle;
        private Integer quantity;
        private Integer pricePerProduct;
        private Integer price;

        private CartItemBuilder() {
        }

        public static CartItemBuilder aCartItemDto() {
            return new CartItemBuilder();
        }

        public CartItemBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public CartItemBuilder withProductTitle(String productTitle) {
            this.productTitle = productTitle;
            return this;
        }

        public CartItemBuilder withQuantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public CartItemBuilder withPricePerProduct(Integer pricePerProduct) {
            this.pricePerProduct = pricePerProduct;
            return this;
        }

        public CartItemBuilder withPrice(Integer price) {
            this.price = price;
            return this;
        }

        public CartItemDto build() {
            CartItemDto cartItemDto = new CartItemDto();
            cartItemDto.setId(id);
            cartItemDto.setProductTitle(productTitle);
            cartItemDto.setQuantity(quantity);
            cartItemDto.setPricePerProduct(pricePerProduct);
            cartItemDto.setPrice(price);
            return cartItemDto;
        }
    }
}
