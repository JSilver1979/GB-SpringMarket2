package ru.gb.jSilver.spring.market.core.data;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Data
@Slf4j
public class Statistics {
    private Map<String,StatItem> statItems;

    @PostConstruct
    public void init() {
        statItems = new HashMap<>();
    }

    public void setData(String serviceName, Long duration) {
        String statServiceName = serviceName.substring(serviceName.lastIndexOf(".") + 1);
        log.info(String.valueOf(statItems.isEmpty()));

        if (!statItems.containsKey(statServiceName)) {
            statItems.put(statServiceName,new StatItem(statServiceName,duration));
        } else {
            StatItem statItem = statItems.get(statServiceName);
            statItem.setDuration(statItem.getDuration() + duration);
        }
    }

    public List<StatItem> getData() {
        return statItems.values().stream().collect(Collectors.toList());
    }

}
