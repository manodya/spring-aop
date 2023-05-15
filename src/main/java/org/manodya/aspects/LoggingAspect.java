package org.manodya.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("@annotation(org.manodya.aspects.interfaces.LogAspect)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info(joinPoint.getSignature().toString() +  " method execution started with parameters :" + Arrays.toString(joinPoint.getArgs()));
        Instant start = Instant.now();
        Object proceed = joinPoint.proceed(); // don't forget to call this
        //joinPoint.proceed(joinPoint.getArgs()); - we can alter input variables and execute method with modified params
        Instant end = Instant.now();
        logger.info("Time taken to execute method(ms) :" + Duration.between(start, end).toMillis());
        logger.info(joinPoint.getSignature().toString() + " method execution ended.");
        return proceed;
    }


    @AfterThrowing(value = "execution(* org.manodya.services.CartService.throwException(..))", throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex){
       logger.severe(joinPoint.getSignature().toString() + " throws an Exception :" + ex.getMessage());
    }

    @After("execution(* org.manodya.services.CartService.throwException(..)))")
    public void logAfterMessage(JoinPoint joinPoint){
        logger.info("After :" + joinPoint.getSignature().toString());
    }

    @Pointcut("execution(* org.manodya.services.CartService.getShoppingCart(..))")
    public void logBefore(){}

    @Before("logBefore()")
    public void  loggingBefore(JoinPoint joinPoint){
        logger.info("New Request: " + joinPoint.getSignature().toString());
    }

    @AfterReturning(value = "execution(* org.manodya.services.CartService.getCartValue(..))", returning = "retVal")
    public void loggingAfterReturning(JoinPoint jp, Object retVal){
        logger.info(jp.getSignature().toString() + " , Completed with the return value of :" + retVal.toString());
    }


}
