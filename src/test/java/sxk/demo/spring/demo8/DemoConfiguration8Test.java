package sxk.demo.spring.demo8;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sxk.demo.spring.demo8.bean.*;
import sxk.demo.spring.demo8.config.DemoConfiguration8;

/**
 * @author : sunxikai
 * @date : 2019-08-22
 */
public class DemoConfiguration8Test {

    /**
     * 名称相同类型不同的bean能否在容器中存在？
     * 只会被加载一个
     */
    @Test
    public void test1() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(DemoConfiguration8.class);
        String[] beans = app.getBeanDefinitionNames();
        for (String bean : beans) {
            System.out.println(bean);
        }
        // 获取的都是 configBird
        System.out.println("通过名称 bird 获取的 bean ： " + app.getBean("bird"));
        System.out.println("通过类型获取的 bean ： " + app.getBean(Bird.class));
    }

    /**
     * 名称相同类型不同的bean能否在容器中存在？
     * 只会被加载一个
     */
    @Test
    public void test2() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(DemoConfiguration8.class);
        String[] beans = app.getBeanDefinitionNames();
        for (String bean : beans) {
            System.out.println(bean);
        }
        // 获取的都是 configBird
        System.out.println("通过名称获取的 bean ： " + app.getBean("dove"));
        System.out.println("通过类型获取的 bean ： " + app.getBean(Dove2.class));
        // NoSuchBeanDefinitionException
        System.out.println("通过类型获取的 bean ： " + app.getBean(Dove.class));
    }

    /**
     * bean的自动注入
     */
    @Test
    public void test3() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(DemoConfiguration8.class);
        Bird2 bird2 = (Bird2) app.getBean("bird2");
        bird2.test();
    }

    /**
     * 相同类型的bean但是名称不同，是否可以通过类型取
     * 不同名称的beanDefinition可以同时存在在容器中但是只能通过name取
     * 如果通过类型取就会报错
     */
    @Test
    public void test4() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(DemoConfiguration8.class);
        String[] definitionNames = app.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
        System.out.println(app.getBean("eagle"));
        // NoUniqueBeanDefinitionException expected single matching bean but found 2
        System.out.println(app.getBean(Eagle.class));
    }

    @Test
    public void test5() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(DemoConfiguration8.class);
        String[] definitionNames = app.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
        System.out.println(app.getBean("eagle"));
        // NoUniqueBeanDefinitionException expected single matching bean but found 2
        System.out.println(app.getBean("eagle1"));
        Eagle2 eagle2 = (Eagle2) app.getBean("eagle2");
        eagle2.test();
    }

    @Test
    public void test6() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(DemoConfiguration8.class);
        PrimaryTestService bean = app.getBean(PrimaryTestService.class);
        bean.test();
        bean.test1();
    }

    @Test
    public void test7() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(DemoConfiguration8.class);
        Swan bean = app.getBean(Swan.class);
        System.out.println(bean.toString());
    }

}