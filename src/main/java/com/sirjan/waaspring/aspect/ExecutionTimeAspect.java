package com.sirjan.waaspring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Aspect
@Component
public class ExecutionTimeAspect {
    @Pointcut("@annotation(com.sirjan.waaspring.aspect.annotation.ExecutionTime)")
    public void showExecutionTime() {
    }

    @Around("showExecutionTime()")
    public void calculationExecutionTime(ProceedingJoinPoint jp) throws Throwable {
        Instant start = Instant.now();
        jp.proceed();
        System.out.println(Duration.between(start, Instant.now()).toMillis());
    }
}
