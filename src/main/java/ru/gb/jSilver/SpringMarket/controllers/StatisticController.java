package ru.gb.jSilver.SpringMarket.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.jSilver.SpringMarket.AppLoggingAspect;
import ru.gb.jSilver.SpringMarket.data.Statistics;
import ru.gb.jSilver.SpringMarket.dto.Cart;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/statistic")
public class StatisticController {
    private final AppLoggingAspect appLoggingAspect;

    @GetMapping
    public Statistics getStatistics() {
        return appLoggingAspect.getTotalDuration();
    }
}
