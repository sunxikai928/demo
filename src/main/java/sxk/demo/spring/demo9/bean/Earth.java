package sxk.demo.spring.demo9.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : sunxikai
 * @date : 2019-08-27
 */
@Component
public class Earth {

    @Autowired
    private Moon moon;

    /**
     * 1 有默认构造：
     * 1.1 没有其他构造函数，执行默认构造
     * 1.2 有其他构造函数，看是否有构造函数有Autowired注解
     * 1.2.1 没有Autowired注解，执行默认构造
     * 1.2.2 有Autowired注解，执行Autowired构造
     * 2 没有默认构造，看是否有构造函数有Autowired注解
     * 2.1 没有Autowired注解，构造函数的参数在容器中能找到对应的bean，就执行
     * 2.2 有Autowired注解，执行Autowired构造
     */
    public Earth() {
    }

    //        @Autowired
    public Earth(Moon moon) {
        System.out.println("Moon通过 Autowired 构造方法注入，moon：" + moon);
        this.moon = moon;
    }

    //        @Autowired
    public void setMoon(Moon moon) {
        System.out.println("Moon通过 Autowired set方法注入");
        this.moon = moon;
    }

    /*
    Autowired : 用在字段上，方法不会默认执行
    public void test(@Autowired Moon moon) {
        System.out.println("Moon通过 Autowired 参数注入");
        this.moon = moon;
    }
     */


}
