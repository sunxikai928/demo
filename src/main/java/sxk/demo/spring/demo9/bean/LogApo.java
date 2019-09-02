package sxk.demo.spring.demo9.bean;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author : sunxikai
 * @date : 2019-08-27
 */
@Aspect
@Component
public class LogApo {

    @Pointcut("@annotation(sxk.demo.spring.demo9.bean.Log)")
    public void log() {
    }

    @After("log()")
    public void after() {
        System.out.println("LogApo after");
    }

    @Before("log()")
    public void before(JoinPoint joinPoint) {
        System.out.println("LogApo before");
        System.out.println(joinPoint.getSignature().getName() + ":" + Arrays.asList(joinPoint.getArgs()));
    }

    @Around("log()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("LogApo around before");
        try {
            Object proceed = pjp.proceed();
            System.out.println("LogApo around after");
            return proceed;
        } catch (Throwable throwable) {
            System.out.println("LogApo around 报错了");
            throw throwable;
        }
    }

    @AfterReturning(value = "log()", returning = "result")
    public void afterReturning(Object result) {
        System.out.println("LogApo afterReturning:" + result);
    }

    @AfterThrowing(value = "log()", throwing = "exception")
    public void afterThrowing(Exception exception) {
        System.err.println("LogApo afterThrowing");
        exception.printStackTrace();
    }

}
