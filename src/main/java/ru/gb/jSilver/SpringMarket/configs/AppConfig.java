package ru.gb.jSilver.SpringMarket.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("ru.gb.jSilver.SpringMarket")
public class AppConfig {
}
