package sxk.demo.spring.annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sxk.demo.spring.pojo.Person;

/**
 * spring配置了类
 * <p>
 * Created by sunxikai on 19/8/9.
 */
// 注解该类是一个配置类
@Configuration
public class MainConfig {

    @Bean
    public Person person() {
        return new Person("李四", 26);
    }
}
