package sxk.demo.spring.demo7.conf;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 面向切面编程，同一个类中的方法相互调用，aop不会生效。
 *
 * @author : sunxikai
 * @date : 2019-08-22
 */
@Aspect
public class AopTest {
    // 这个包下所有类的所有方法
    @Pointcut(value = "execution(* sxk.demo.spring.demo7.bean.Ship.test4())")
    public void pointcut() {

    }

    @Before("pointcut()")
    public void before() {
        System.out.println("aop方法前执行");
    }

    @After("pointcut()")
    public void after() {
        System.out.println("aop方法后执行");
    }
}
