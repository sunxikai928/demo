package sxk.demo.spring1.config;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sxk.demo.spring.annotation.config.MainConfig;
import sxk.demo.spring1.pojo.Person;

/**
 * Created by sunxikai on 19/8/9.
 */
public class AnnotationApplicationTest {

    @Test
    public void testMainConfig() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = (Person) app.getBean("person");
        System.out.println("姓名:" + person.getName() + ",年龄:" + person.getAge());
    }

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
    public void testMainConfig4() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(MainConfig4.class);
        System.out.println("容器加载完成");
        app.getBean("person");
    }
}
