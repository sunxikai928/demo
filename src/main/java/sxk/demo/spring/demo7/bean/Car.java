package sxk.demo.spring.demo7.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Car {
    public Car() {
        System.out.println("Car 的 构造 方法");
    }

    /**
     * 初始化的时候执行的方法
     */
    @PostConstruct
    public void init() {
        System.out.println("Car 的 @PostConstruct 方法");
    }

    /**
     * 容器销毁的时候会执行的方法
     */
    @PreDestroy
    public void destroy() {
        System.out.println("Car 的 @PreDestroy 方法");
    }
}
