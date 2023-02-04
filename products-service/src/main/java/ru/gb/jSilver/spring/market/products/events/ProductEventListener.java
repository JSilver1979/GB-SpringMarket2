package ru.gb.jSilver.spring.market.products.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductEventListener {

    @EventListener(ProductEvent.class)
    public void eventHappened(ProductEvent event) {
        log.info("NEW EVENT: " + event);
    }
}
