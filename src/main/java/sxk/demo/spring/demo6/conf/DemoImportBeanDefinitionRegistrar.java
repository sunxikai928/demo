package sxk.demo.spring.demo6.conf;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import sxk.demo.spring.demo6.pojo.Monkey;

/**
 * 自定义向容器中注册bean
 *
 */
public class DemoImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     * 可以直接向容器中注册bean
     * importingClassMetadata 会传 sxk.demo.spring1.demo6.conf.DemoConfig6
     *
     * @param importingClassMetadata 配置类的注解信息
     * @param registry               可以获取容器中的注册信息
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        System.out.println("DemoImportBeanDefinitionRegistrar#registerBeanDefinitions 被调用了; className:" + importingClassMetadata.getClassName());
        // 如果存在容器中存在 littleDog 那么向容器中注册 Monkey
        if (registry.containsBeanDefinition("littleDog")) {
            RootBeanDefinition beanDefinition = new RootBeanDefinition(Monkey.class);
            registry.registerBeanDefinition("sxk.demo.spring.demo6.pojo.Monkey", beanDefinition);
        }
    }
}
