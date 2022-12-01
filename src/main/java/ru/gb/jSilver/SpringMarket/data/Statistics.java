package ru.gb.jSilver.SpringMarket.data;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Data
public class Statistics {
    private Long cartServiceDuration;
    private Long orderServiceDuration;
    private Long productServiceDuration;

    @PostConstruct
    public void init() {
        cartServiceDuration = 0L;
        orderServiceDuration = 0L;
        productServiceDuration = 0L;
    }

    public void setData(String serviceName, Long duration) {
        if (serviceName.contains("CartService")) {
            cartServiceDuration += duration;
        }
        if (serviceName.contains("OrdersService")) {
            orderServiceDuration += duration;
        }
        if (serviceName.contains("ProductService")) {
            productServiceDuration += duration;
        }
    }

}
