package org.tms.dz33.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

    @Pointcut("@annotation(org.tms.dz33.aop.MyBenchmark)")
    public void pointCutForBenchmark() {};

    @Around("pointCutForBenchmark()")
    public Object runAdvice(ProceedingJoinPoint joinPoint) {
        System.out.println("---start-race---");
        long timeStart = System.currentTimeMillis();

        Object proceed;
        try {
            proceed = joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        long timeEnd = System.currentTimeMillis();
        System.out.println("rice end time: " + (timeEnd - timeStart));
        return proceed;
    }

}
