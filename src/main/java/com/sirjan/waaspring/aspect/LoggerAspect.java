package com.sirjan.waaspring.aspect;

import com.sirjan.waaspring.domain.Logger;
import com.sirjan.waaspring.service.LoggerService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class LoggerAspect {

    @Pointcut("within(com.sirjan.waaspring.controller..*)")
    public void loggerAnnotation() {}

    @Autowired
    private LoggerService loggerService;

    @Before("loggerAnnotation()")
    public void logBefore(JoinPoint jp) {
        Logger logger = new Logger();
        logger.setPrinciple("Default");
        logger.setOperation(jp.getSignature().toShortString());
        logger.setDateTime(LocalDateTime.now());

        loggerService.save(logger);
    }
}
