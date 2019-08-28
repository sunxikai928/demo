package sxk.demo.spring.demo9.bean;

import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;
import sxk.demo.spring.demo7.bean.MotorbikeAware;

/**
 * {@link Aware} : 由容器注入感兴趣的对象
 * 详见 {@link MotorbikeAware}
 * @author : sunxikai
 * @date : 2019-08-27
 */
@Component
public class Star implements BeanNameAware {
    private String name;

    @Override
    public void setBeanName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Star{" +
                "name='" + name + '\'' +
                '}';
    }
}
