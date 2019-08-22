package sxk.demo.spring.demo8.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author : sunxikai
 * @date : 2019-08-22
 */
@Component
public class Bird2 {

    // 自动注入的就是容器中加载的那个 beanDefintion
    @Autowired
    private Bird bird;

    public void test() {
        System.out.println("Bird2 中的 test方法：" + bird.toString());
    }
}
