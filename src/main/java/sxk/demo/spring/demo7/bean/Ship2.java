package sxk.demo.spring.demo7.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : sunxikai
 * @date : 2019-08-22
 */
@Component
public class Ship2 {

    @Autowired
    private Ship ship;

    /**
     * 在不同类中调用 Async 方法
     */
    public void test1() {
        System.out.println("Ship2的test1方法");
        ship.test3();
    }

    /**
     * 在不同类中调用aop编程
     */
    public void test2() {
        System.out.println("Ship2的test2方法");
        ship.test4();
    }
}
