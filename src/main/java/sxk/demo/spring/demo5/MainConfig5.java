package sxk.demo.spring.demo5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import sxk.demo.spring.demo5.condition.*;
import sxk.demo.spring.demo2.pojo.Person;

/**
 * TODO 没有实现，不知道为什么取到的环境变量是空的
 * spring配置了类
 * <p>
 * Created by sunxikai on 19/8/9.
 */
// 注解该类是一个配置类
@Configuration
public class MainConfig5 {
    @Bean("Windows")
    @Conditional(WindowsCondition.class)
    public Person windows() {
        return new Person("Windows", 26);
    }

    @Bean("linux")
    @Conditional(LinuxCondition.class)
    public Person linux() {
        return new Person("linux", 26);
    }

    @Bean("mac")
    @Conditional(MacCondition.class)
    public Person mac() {
        return new Person("mac", 26);
    }
}
