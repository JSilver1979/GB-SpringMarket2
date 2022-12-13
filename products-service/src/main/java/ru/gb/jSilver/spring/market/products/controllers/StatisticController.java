package ru.gb.jSilver.spring.market.products.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.jSilver.spring.market.products.data.Statistics;
import ru.gb.jSilver.spring.market.products.data.StatItem;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/statistic")
public class StatisticController {
    private final Statistics statistics;

    @GetMapping
    public List<StatItem> statItemList () {
        return statistics.getData();
    }
}
