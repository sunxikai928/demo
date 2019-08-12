package sxk.demo.spring.demo2;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sxk.demo.spring.demo5.MainConfig5;

/**
 * Created by sunxikai on 19/8/9.
 */
public class AnnotationApplicationTest {

    @Test
    public void testMainConfig2() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(MainConfig2.class);
        /*
        当注解打在接口上的时候是无法获取该bean的
        app.getBean("personDao");
         */
        String[] definitions = app.getBeanDefinitionNames();
        for (String definition : definitions) {
            System.out.println(definition);
        }
    }

    @Test
    public void testMainConfig3() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(MainConfig3.class);
        /*
        当注解打在接口上的时候是无法获取该bean的
        app.getBean("personDao");
         */
        // 拿出所有的 bean 的定义
        String[] definitions = app.getBeanDefinitionNames();
        for (String definition : definitions) {
            System.out.println(definition);
        }
    }

    @Test
    public void testMainConfig5() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(MainConfig5.class);
        System.out.println("容器创建完成");
    }
}
