package sxk.demo.spring.annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Service;
import sxk.demo.spring.dao.PersonDao;
import sxk.demo.spring.service.PersonService;
import sxk.demo.spring.web.PersonRest;

/**
 * spring配置了类
 * <p>
 * Created by sunxikai on 19/8/9.
 */
/*
value：指定要扫描的package；
includeFilters=Filter[]：指定只包含的组件
excludeFilters=Filter[]：指定需要排除的组件；
useDefaultFilters=true/false：指定是否需要使用Spring默认的扫描规则：被@Component, @Repository, @Service, @Controller或者已经声明过@Component自定义注解标记的组件；

在过滤规则Filter中：
FilterType：指定过滤规则，支持的过滤规则有
    ANNOTATION：按照注解规则，过滤被指定注解标记的类；
    ASSIGNABLE_TYPE：按照给定的类型；
    ASPECTJ：按照ASPECTJ表达式；
    REGEX：按照正则表达式
    CUSTOM：自定义规则；
value：指定在该规则下过滤的表达式；

指定扫描路径
@ComponentScan(value = "sxk.demo.spring")
指定类的包
@ComponentScan(basePackageClasses = PersonService.class)
 */
// 注解该类是一个配置类
@Configuration
@ComponentScan(
        // 配置基础注解包
        value = "sxk.demo.spring",
        // 是否懒加载，默认是 false
        lazyInit = true,
        // 指定只包含的组件
        includeFilters = {
                // 只加载打了 Service 注解的类
                @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Service.class),
                // 只加载指定的类型
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = {PersonRest.class, PersonDao.class}),
                // 自定义过滤规则
                @ComponentScan.Filter(type = FilterType.CUSTOM, value = MyBeanLoadFilter.class)
        },
        // 指定需要排除的组件
        excludeFilters = {
                // 排除具体的类,无论如何都不会被加载
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = PersonService.class)
        },
        // 是否使用默认的过滤器,如果选择使用默认过滤器则 includeFilters 不生效
        useDefaultFilters = false
)
public class MainConfig2 {

}
