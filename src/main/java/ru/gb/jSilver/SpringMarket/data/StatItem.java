package ru.gb.jSilver.SpringMarket.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StatItem {
    private String name;
    private Long duration;
}
