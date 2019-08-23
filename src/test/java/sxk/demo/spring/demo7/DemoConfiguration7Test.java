package sxk.demo.spring.demo7;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sxk.demo.spring.demo7.bean.Bike;
import sxk.demo.spring.demo7.bean.Ship;
import sxk.demo.spring.demo7.bean.Ship2;
import sxk.demo.spring.demo7.conf.Demo2Configuration7;
import sxk.demo.spring.demo7.conf.DemoConfiguration7;

public class DemoConfiguration7Test {

    @Test
    public void test1() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(DemoConfiguration7.class);
        System.out.println("容器加载完成");
        Bike bike = (Bike) app.getBean("bike");
        System.out.println(bike);
        app.close();
        System.out.println("容器销毁完成");
    }

    @Test
    public void test2() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(DemoConfiguration7.class);
        // 同一个类中打了异步注解，不生效
        Ship ship = (Ship) app.getBean("ship");
        ship.test1();
        // 不同类中，打了异步注解能生效
        Ship2 ship2 = (Ship2) app.getBean("ship2");
        ship2.test1();
    }

    @Test
    public void test3() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(DemoConfiguration7.class);
        Ship ship = (Ship) app.getBean("ship");
        ship.test2();
        Ship2 ship2 = (Ship2) app.getBean("ship2");
        ship2.test2();
    }

    @Test
    public void test4() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Demo2Configuration7.class);
        System.out.println(app.getBean("motorbikeAware").toString());
    }

}