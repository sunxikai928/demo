package sxk.demo.spring.demo6.conf;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoConfig6Test {

    @Test
    public void test1() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(DemoConfig6.class);
        System.out.println("----------------------所有的bean定义----------------------");
        String[] beanDefinitionNames = app.getBeanDefinitionNames();
        for (String definitionName : beanDefinitionNames) {
            System.out.println(definitionName);
        }
        System.out.println("----------------------FactoryBean 加载的实际类型----------------------");
        // 结果 ：class sxk.demo.spring1.demo6.pojo.Tiger
        System.out.println(app.getBean("sxk.demo.spring1.demo6.conf.TigerFactoryBean").getClass());
    }
}