package sxk.demo.spring.demo6;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sxk.demo.spring.demo6.conf.DemoConfig6;
import sxk.demo.spring.demo6.pojo.Horse;

public class DemoConfig6Test {

    @Test
    public void test1() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(DemoConfig6.class);
        System.out.println("----------------------所有的bean定义----------------------");
        String[] beanDefinitionNames = app.getBeanDefinitionNames();
        for (String definitionName : beanDefinitionNames) {
            System.out.println(definitionName);
        }
        System.out.println("----------------------TigerFactoryBean 加载的实际类型----------------------");
        // 结果 ：class sxk.demo.spring1.demo6.pojo.Tiger
        System.out.println(app.getBean("sxk.demo.spring.demo6.conf.TigerFactoryBean").getClass());
        System.out.println("----------------------HorseFactoryBean 加载的实际类型----------------------");
        // 看去除来的类型是 Horse 还是 HorseFactoryBean
        // 这里的Horse 可以被强转成 Horse
        Horse horse1 = (Horse) app.getBean("horse");
        Horse horse2 = (Horse) app.getBean("horse");
        // HorseFactoryBean 中我们设置了单例是 false，
        System.out.println(horse1 == horse2);
    }
}