package ru.gb.jSilver.SpringMarket;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import ru.gb.jSilver.SpringMarket.data.Statistics;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class AppLoggingAspect {
    private final Statistics statistics;

    public Statistics getTotalDuration() {
        return statistics;
    }


    @Around("execution(public * ru.gb.jSilver.SpringMarket.services.*Service.*(..))")
    public Object aroundCartServiceAdd(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object out = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        long duration = end - start;
        statistics.setData(((MethodSignature) proceedingJoinPoint.getSignature()).toString(),duration);
        return out;
    }
}
