package ru.gb.jSilver.spring.market.products.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StatItem {
    private String name;
    private Long duration;
}
