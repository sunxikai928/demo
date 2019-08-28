package sxk.demo.spring;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sxk.demo.spring.demo9.bean.Earth;
import sxk.demo.spring.demo9.bean.Sun;
import sxk.demo.spring.demo9.config.Demo9Configuration;

/**
 * @author : sunxikai
 * @date : 2019-08-27
 */
public class Demo9ConfigurationTest {

    /**
     * Autowired 自动注入，构造方法，普通方法，字段，参数
     */
    @Test
    public void test1() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Demo9Configuration.class);
        System.out.println("容器初始化完成");
        Earth earth = (Earth) app.getBean("earth");
    }

    /**
     * BeanNameAware 注入beanName
     * Star{name='star'}
     */
    @Test
    public void test2() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Demo9Configuration.class);
        System.out.println(app.getBean("star"));
    }

    /**
     * aop正常返回
     * LogApo around before
     * LogApo before
     * Sun shine.
     * LogApo around after
     * LogApo after
     * LogApo afterReturning
     */
    @Test
    public void test3() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Demo9Configuration.class);
        Sun sun = (Sun) app.getBean("sun");
        sun.shine(3);
    }

    /**
     * aop 获取异常
     * LogApo around before
     * LogApo before
     * LogApo around 报错了
     * LogApo after
     * LogApo
     * java.lang.ArithmeticException: / by zero
     */
    @Test
    public void test4() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Demo9Configuration.class);
        Sun sun = (Sun) app.getBean("sun");
        sun.shine1(0);
    }

}