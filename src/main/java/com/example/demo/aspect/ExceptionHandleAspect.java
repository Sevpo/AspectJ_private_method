package com.example.demo.aspect;

import com.example.demo.annotation.MyException;
import com.example.demo.annotation.MyException2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExceptionHandleAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @After("@annotation(com.example.demo.annotation.Loggable)")
    public void afterLogging(JoinPoint joinPoint){
        logger.info("Hello from: {} ", joinPoint.getSignature());
    }

    /*@Around("@annotation(com.example.demo.annotation.Exception)")
    public Object afterException(ProceedingJoinPoint pjp) throws Throwable{
        try {
            return pjp.proceed();
        } catch (ArithmeticException e) {
            logger.info("Exception handled by aspect -> {}", e.getMessage());
            throw new MyException();
        }
    }*/

    @AfterThrowing(value = "@annotation(com.example.demo.annotation.Exception)", throwing = "ex")
    public void afterException(JoinPoint jp, MyException ex) {
        logger.info("Exception handled by aspect in {} -> handle {}", jp.getSignature(), ex);
        throw new RuntimeException();
    }

    @AfterThrowing(value = "@annotation(com.example.demo.annotation.Exception)", throwing = "ex")
    public void afterException(JoinPoint jp, MyException2 ex) {
        logger.info("Exception handled by aspect in {} -> handle {}", jp.getSignature(), ex);
        throw new IllegalArgumentException();
    }
}
