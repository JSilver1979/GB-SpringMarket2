package ru.gb.jSilver.spring.market.products.events;

import org.springframework.context.ApplicationEvent;

public class ProductEvent extends ApplicationEvent {

    private final Long id;
    private final String title;
    private final String status;

    public ProductEvent(Object source, Long id, String title, String status) {
        super(source);
        this.id = id;
        this.title = title;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }
}
