package sxk.demo.spring.demo7.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Car {
    public Car() {
        System.out.println("Car 的 构造 方法");
        }

    /**
     * 初始化的时候执行的方法
     * 这种方式是通过 BeanPostProcessor 处理器的方式执行的
     * 是通过注册在{@link AbstractBeanFactory#beanPostProcessors}中的
     * {@link InitDestroyAnnotationBeanPostProcessor#postProcessBeforeInitialization}被调用才最后调用到我们注册的方法
     * {@link AbstractBeanFactory#beanPostProcessors}中的处理器都会被执行一遍，这是执行初始化方法之前的处理
     *
     * 这种初始化方法是在后置处理器中执行，在 {@link InitializingBean#afterPropertiesSet} 方法执行之前，这时候不知道属性是否已经赋值完成了
     * 如果必须要在属性赋值完成之后才能执行的，要在用继承 InitializingBean 接口
     * 或者，在 @Bean(initMethod = "init", destroyMethod = "destroy")指定
     */
    @PostConstruct // 只能保证构造方法肯定执行完成了
    public void init() {
        System.out.println("Car 的 @PostConstruct 方法");
    }

    /**
     * 容器销毁的时候会执行的方法
     */
    @PreDestroy
    public void destroy() {
        System.out.println("Car 的 @PreDestroy 方法");
    }
}
