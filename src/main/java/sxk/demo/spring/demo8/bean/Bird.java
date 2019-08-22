package sxk.demo.spring.demo8.bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * 同一个类如果不取别名，它的 beanDefinition 只会被加载一次
 * 第一次被加载，容器中已经存在了就不会再被加载了。
 * 这里加了Primary也不会生效的，Primary是针对需要注入的是父类型，但是我有多个子类型，那么会默认使用打了Primary注解的
 *
 * @author : sunxikai
 * @date : 2019-08-22
 */
// 不生效，这个没有被加载
@Primary
@Component
public class Bird {
    private String name = "defaultBird";

    public Bird() {
    }

    public Bird(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "name='" + name + '\'' +
                '}';
    }
}
