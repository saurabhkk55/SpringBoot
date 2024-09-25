package com.example.aop.aop.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
    // 1
    // @Before("execution (* orderPackage(..))")
    // @Before("execution(* com.example.aop.aop.services.impl.ShipmentServiceImpl.orderPackage(Long))")
    // @Before("execution(* com.example.aop.aop.services.impl.*.orderPackage(..))")
    // @Before("execution(* com.example.aop.aop.services.impl.*.*(..))")
    // public void beforeOrderPackageMethods(JoinPoint joinPoint) {
    //     log.info("Before method call {}: ", joinPoint.getSignature());
    // }

    // 2
    // @After("execution(* com.example.aop.aop.services.impl.ShipmentServiceImpl.*(..))")
    // public void afterShipmentServiceMethods(JoinPoint joinPoint) {
    //     log.info("After method call {}: ", joinPoint.getSignature());
    // }

    // 3
    // @Before("within(com.example.aop.aop.services.impl.*)")
    // @Before("within(com.example.aop.aop..*)")
    // public void forAllMethodsunderImplPackages(JoinPoint joinPoint) {
    //     log.info("Before-within called {}", joinPoint.getSignature());
    // }

    // 4.1
    // @Before("@annotation(org.springframework.transaction.annotation.Transactional)")
    // public void beforeTransactionalAnnotationCalls(JoinPoint joinPoint) {
    //     log.info("Before-Transactional-Annotation called [{}]", joinPoint.getSignature());
    // }

    // 4.2
    // @Before("@annotation(com.example.aop.aop.annotation.MyLogging)")
    // public void beforeMyLoggingAnnotationCalls(JoinPoint joinPoint) {
    //     log.info("Before-MyLogging-Annotation called [{}]", joinPoint.getSignature());
    // }

    // 4.3
    // @Before("@annotation(com.example.aop.aop.annotation.MyLogging) && within(com.example.aop.aop..*)")
    // public void beforeMyLoggingAnnotationCalls(JoinPoint joinPoint) {
    //     log.info("Before-MyLogging-Annotation called [{}]", joinPoint.getSignature());
    // }

    // 5
    @Pointcut("execution(* com.example.aop.aop.services.impl.*.*(..))")
    public void myAopMethodsPointCut() {}

    // 5.1
    // @Before("myAopMethodsPointCut()")
    // public void customPointCutforRepeatedUsageBefore() {
    //     log.info("Before-customPointCutforRepeatedUsageBefore invoked");
    // }

    // Note:
    // @After = @AfterReturning + @AfterThrowing
    // @After is a collection of both @AfterReturning and @AfterThrowing

    // 5.2
    // @After("myAopMethodsPointCut()")
    // public void customPointCutforRepeatedUsageAfter() {
    //     log.info("After-customPointCutforRepeatedUsageAfter invoked");
    // }

    // 5.3
    // @AfterReturning("myAopMethodsPointCut()")
    // public void customPointCutforRepeatedUsageAfterReturning(JoinPoint joinPoint) {
    //     log.info("AfterReturning-customPointCutforRepeatedUsageAfter invoked: {}", joinPoint.getSignature());
    // }

    // 5.4
    // @AfterReturning(value = "myAopMethodsPointCut()", returning = "returnedObj")
    // public void customPointCutforRepeatedUsageAfterReturning(JoinPoint joinPoint, Object returnedObj) {
    //     log.info("AfterReturning-customPointCutforRepeatedUsageAfter invoked: {}", joinPoint.getSignature());
    //     log.info("AfterReturning-customPointCutforRepeatedUsageAfter returned value: {}", returnedObj);
    // }

    // 5.5
    // @AfterThrowing(value = "myAopMethodsPointCut()")
    // public void customPointCutforRepeatedUsageAfterReturning(JoinPoint joinPoint) {
    //     log.info("AfterThrowing-customPointCutforRepeatedUsageAfter invoked: {}", joinPoint.getSignature());
    // }

    // 5.6
    @Around("myAopMethodsPointCut()")
    public Object validateOrderId(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object args[] = proceedingJoinPoint.getArgs();
        Long orderId = (Long)args[0];
        if(orderId > 0) return proceedingJoinPoint.proceed();
        return "Cannot call with negative order id";
    }

    // 5.7
    @Around("myAopMethodsPointCut()")
    public Object logExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Long startTime = System.currentTimeMillis();
        Object returnedValue = proceedingJoinPoint.proceed();
        Long endTime = System.currentTimeMillis();

        log.info("startTime: {}", startTime);
        log.info("returnedValue: {}", returnedValue);

        Long diff = endTime-startTime;
        log.info("diff: {}", diff);
        log.info("Time taken for {} is {}", proceedingJoinPoint.getSignature(), diff);
        return returnedValue;
    }
}
