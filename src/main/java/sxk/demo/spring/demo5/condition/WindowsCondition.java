package sxk.demo.spring.demo5.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WindowsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 获取IOC容器的 beanFactory
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        // 获取系统的环境变量
        Environment environment = context.getEnvironment();
        String[] defaultProfiles = environment.getDefaultProfiles();
        for (String profile : defaultProfiles) {
            System.out.println(profile);
            System.out.println(environment.getProperty(profile));
        }
        String osName = environment.getProperty("os.name");
        if (osName.contains("Windows"))
            return true;
        return false;
    }
}
