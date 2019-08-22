package sxk.demo.spring.demo8.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author : sunxikai
 * @date : 2019-08-22
 */
@Component
public class Eagle2 {

    // 一个类型多个对象的时候可以通过字段名来确认
    @Autowired
    private Eagle eagle;

    // 指定注入的bean名称
    @Qualifier("eagle")
    @Autowired
    private Eagle eagle3;

    // 指定注入的bean名称
    @Resource(name = "eagle1")
    private Eagle eagle1;

    public void test() {
        System.out.println("Eagle2 通过 Autowired + 固定字段名 注入 eagle：" + eagle);
        System.out.println("Eagle2 通过 Qualifier + Autowired 注入 eagle：" + eagle3);
        System.out.println("Eagle2 通过 Resource 注入 eagle1：" + eagle1);
    }
}
