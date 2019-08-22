package sxk.demo.spring.demo7.bean;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 同一个类中的方法相互调用，面向切面编程是否还生效
 * 所有通过代理进行增强的功能在同一个类里相互调用的时候都不生效
 *
 * @author : sunxikai
 * @date : 2019-08-22
 */
@Component
public class Ship {

    public void test1() {
        /*
         同一个对象中调用异步方法没有效果，是同步执行的
         因为同一个对象中直接调用是没有经过代理的
         */
        test3();
        System.out.println("方法1，当前执行的线程" + Thread.currentThread().getName());
    }

    /**
     * 异步方法
     * 必须先开启异步否则不生效
     */
    @Async
    public void test3() {
        System.out.println("方法3，异步方法，当前执行的线程" + Thread.currentThread().getName());
    }

    public void test2() {
        System.out.println("方法2");
        test4();
    }

    public void test4() {
        System.out.println("方法4");
    }
}
