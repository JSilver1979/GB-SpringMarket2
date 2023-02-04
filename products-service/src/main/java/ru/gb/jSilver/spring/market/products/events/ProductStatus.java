package ru.gb.jSilver.spring.market.products.events;

public enum ProductStatus {
    PRICE_UPDATED ("Price has been updated"),
    NAME_UPDATED ("Name has been updated"),
    DESCRIPTION_UPDATED ("Description has been updated"),
    PRODUCT_ADDED ("New product added"),
    PRODUCT_DELETED ("Product deleted");

    private final String status;

    ProductStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }
}
