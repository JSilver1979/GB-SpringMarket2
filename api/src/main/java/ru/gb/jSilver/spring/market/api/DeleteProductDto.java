package ru.gb.jSilver.spring.market.api;

public class DeleteProductDto {
    private Long id;

    public DeleteProductDto(Long id) {
        this.id = id;
    }

    public DeleteProductDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
