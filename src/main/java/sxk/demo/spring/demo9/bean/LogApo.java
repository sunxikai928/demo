package sxk.demo.spring.demo9.bean;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

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
    public void before() {
        System.out.println("LogApo before");
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

    @AfterReturning("log()")
    public void afterReturning(){
        System.out.println("LogApo afterReturning");
    }

    @AfterThrowing("log()")
    public void afterThrowing(){
        System.out.println("LogApo afterThrowing");
    }

}
