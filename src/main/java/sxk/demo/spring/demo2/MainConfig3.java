package sxk.demo.spring.demo2;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Service;
import sxk.demo.spring.demo2.pojo.Person;

/**
 * spring配置了类
 * <p>
 * Created by sunxikai on 19/8/9.
 */
// 注解该类是一个配置类
@Configuration
// 可以配置多个 ComponentScan
@ComponentScans(value = {
        // 指定扫描包
        @ComponentScan(value = "sxk.demo.spring.demo2.dao"),
        // 配置其它类型的扫描
        @ComponentScan(
                value = "sxk.demo.spring.demo2.service",
                useDefaultFilters = false,
                includeFilters = {
                        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Service.class})
                }
        )
})
public class MainConfig3 {
    @Bean
    /*
    多例：ConfigurableBeanFactory#SCOPE_PROTOTYPE 每次向容器中获取都会创建一个新的对象
    单例：ConfigurableBeanFactory#SCOPE_SINGLETON 这个容器只有一个实例
    请求：WebApplicationContext#SCOPE_REQUEST 每个请求都创建一个实例
    会话：WebApplicationContext#SCOPE_SESSION 每个会话都创建一个实例
     */
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
    // 懒加载, 向容器获取的时候才创建实例
    // 不加这个注解就是容器初始化的时候立刻就创建了
    @Lazy
    public Person person() {
        return new Person("李四", 26);
    }
}
