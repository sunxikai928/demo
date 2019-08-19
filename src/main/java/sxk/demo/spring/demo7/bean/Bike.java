package sxk.demo.spring.demo7.bean;

import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;

public class Bike {
    public Bike() {
        System.out.println("Bike 的构造方法");
    }

    /**
     * 初始化的时候执行的方法
     * 使用@Bean.initMethod="init" 会在 会在创建bean中，属性赋值之后执行
     * 在 AbstractAutowireCapableBeanFactory 中的 doCreateBean 中的 initializeBean
     * 最终在这个方法中调用 {@link AbstractAutowireCapableBeanFactory#invokeInitMethods}
     */
    public void init() {
        System.out.println("Bike 的 init 方法");
    }

    /**
     * 容器销毁的时候会执行的方法
     */
    public void destroy() {
        System.out.println("Bike 的 destroy 方法");
    }
}
