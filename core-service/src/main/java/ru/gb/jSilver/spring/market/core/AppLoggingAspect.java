package ru.gb.jSilver.spring.market.core;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.gb.jSilver.spring.market.core.data.Statistics;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class AppLoggingAspect {
    private final Statistics statistics;

    @Around("execution(public * ru.gb.jSilver.SpringMarket.services.*Service.*(..))")
    public Object aroundCartServiceAdd(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object out = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        long duration = end - start;
        statistics.setData(proceedingJoinPoint.getSignature().getDeclaringTypeName(),duration);
        log.info(proceedingJoinPoint.getSignature().getDeclaringTypeName() + " duration: " + duration);
        return out;
    }
}
