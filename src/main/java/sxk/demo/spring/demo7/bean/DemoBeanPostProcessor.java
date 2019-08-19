package sxk.demo.spring.demo7.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * init 方法的处理器的增强
 * 容器中的所有类实例化的时候都会执行
 * 如果有init方法会在 init 的前后执行
 * 如果没有init方法，会直接执行这两个方法
 */
@Component
public class DemoBeanPostProcessor implements BeanPostProcessor {
    /**
     * 在init方法之前执行
     *
     * @param bean
     * @param beanName
     * @return 这里不能返回null，返回null的时候会导致打了 @PostConstruct 注解的方法不执行
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("DemoBeanPostProcessor#postProcessBeforeInitialization : beanName = " + beanName + ", bean = " + bean);
        return bean;
    }

    /**
     * 在init方法之后执行
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("DemoBeanPostProcessor#postProcessAfterInitialization : beanName = " + beanName + ", bean = " + bean);
        return bean;
    }
}
