package sxk.demo.spring.demo7.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import sxk.demo.spring.demo7.bean.Bike;

@Configuration
/*
 允许异步执行，在 EnableAsync上有 @Import(AsyncConfigurationSelector.class) 会加载 AsyncConfigurationSelector
 AsyncConfigurationSelector 会加载 ProxyAsyncConfiguration 或者 AspectJAsyncConfiguration
ProxyAsyncConfiguration 是一个配置类会生成一个 Bean ：AsyncAnnotationBeanPostProcessor 专门处理异步注解的后置处理器
在加载类的时候如果有方法打了@Async，生成的代理类就会把这个方法进行增强，别的类型的对象调用的时候异步执行
如果是自己的类调用这个异步方法，因为不通过spring的代理类执行所以不会异步执行
 */
@EnableAsync
@EnableAspectJAutoProxy
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

    /**
     * 生成aop增强类
     *
     * @return
     */
    @Bean
    public AopTest aopTest() {
        return new AopTest();
    }
}
