package sxk.demo.spring.demo7.conf;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sxk.demo.spring.demo7.bean.Bike;

public class DemoConfiguration7Test {

    @Test
    public void test() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(DemoConfiguration7.class);
        System.out.println("容器加载完成");
        Bike bike = (Bike) app.getBean("bike");
        System.out.println(bike);
        app.close();
        System.out.println("容器销毁完成");
    }

}