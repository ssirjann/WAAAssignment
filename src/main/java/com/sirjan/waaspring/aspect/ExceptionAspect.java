package com.sirjan.waaspring.aspect;

import com.sirjan.waaspring.domain.Exception;
import com.sirjan.waaspring.service.ExceptionService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class ExceptionAspect {

    private ExceptionService exceptionService;

    @Autowired
    public ExceptionAspect(ExceptionService exceptionService){
        this.exceptionService = exceptionService;
    }

    @Pointcut("within(com.sirjan.waaspring..*.*)")
    public void logException() {}

    @AfterThrowing(value = "logException()", throwing = "ex")
    public void logExceptionThrown(JoinPoint jp, java.lang.Exception ex) {
        Exception exception = new Exception();
        exception.setOperation(jp.getSignature().toShortString());
        exception.setPrinciple("Sirjan");
        exception.setExceptionType(ex.getClass().toString());
        exception.setMessage(ex.getMessage());
        exception.setDateTime(LocalDateTime.now());

        exceptionService.save(exception);

    }
}
