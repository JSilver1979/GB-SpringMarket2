package ru.gb.jSilver.SpringMarket.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.jSilver.SpringMarket.data.StatItem;
import ru.gb.jSilver.SpringMarket.data.Statistics;

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
