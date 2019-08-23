package sxk.demo.spring.demo8.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author : sunxikai
 * @date : 2019-08-23
 */
@Component
public class Swan {
    @Value("小白")
    private String name;
    @Value("#{10-8}")
    private int age;
    // 这种语法需要加载配置文件 test8.properties 否则找不到 demo8.swan.color
    @Value("${demo8.swan.color}")
    private String color;

    @Override
    public String toString() {
        return "Swan{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
