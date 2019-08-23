package sxk.demo.spring.demo7.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * Aware ： 实现了指定的接口spring就会将指定的对象注入进来
 * 是通过 ApplicationContextAwareProcessor 进行注入的
 * ApplicationContextAwareProcessor 是在 容器 refresh 方法调用 prepareBeanFactory 方法的时候被加入 BeanPostProcessor 集合的
 *
 * @author : sunxikai
 * @date : 2019-08-23
 */
public class MotorbikeAware implements EnvironmentAware, EmbeddedValueResolverAware, ResourceLoaderAware,
        ApplicationEventPublisherAware, MessageSourceAware, ApplicationContextAware {
    // 容器上下文
    private ApplicationContext applicationContext;
    private ApplicationEventPublisher applicationEventPublisher;
    private StringValueResolver resolver;
    private Environment environment;
    private MessageSource messageSource;
    private ResourceLoader resourceLoader;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        System.out.println("");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.resolver = resolver;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public String toString() {
        return "MotorbikeAware{" +
                "applicationContext=" + applicationContext +
                ", applicationEventPublisher=" + applicationEventPublisher +
                ", resolver=" + resolver +
                ", environment=" + environment +
                ", messageSource=" + messageSource +
                ", resourceLoader=" + resourceLoader +
                '}';
    }
}
