package sxk.demo.spring.demo9.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * {@link Autowired} 的使用
 * 1.可以打在构造方法，普通方法，参数，字段，注解
 * 2.required 是否必须，默认是找不到会报错
 * <p>
 * aop：通过配置无侵入的对方法增强
 *
 * @author : sunxikai
 * @date : 2019-08-27
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(value = "sxk.demo.spring.demo9.bean")
public class Demo9Configuration {

}
