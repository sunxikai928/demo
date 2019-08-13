package sxk.demo.spring.demo7.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import sxk.demo.spring.demo7.bean.Bike;

@Configuration
@ComponentScan(value = "sxk.demo.spring.demo7.bean")
public class DemoConfiguration7 {
    /**
     * 如果是指定初始化和销毁方法就不能使用多实例，这是因为多实例是在 getBean 的时候才能创建对象
     * 不能使用 @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
     *
     * @return
     */
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Bike bike() {
        return new Bike();
    }
}
