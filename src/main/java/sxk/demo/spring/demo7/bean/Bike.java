package sxk.demo.spring.demo7.bean;

public class Bike {
    public Bike() {
        System.out.println("Bike 的构造方法");
    }

    /**
     * 初始化的时候执行的方法
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
