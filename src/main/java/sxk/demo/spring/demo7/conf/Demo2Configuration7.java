package sxk.demo.spring.demo7.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sxk.demo.spring.demo7.bean.MotorbikeAware;

@Configuration
public class Demo2Configuration7 {

    @Bean
    public MotorbikeAware motorbikeAware() {
        return new MotorbikeAware();
    }
}
