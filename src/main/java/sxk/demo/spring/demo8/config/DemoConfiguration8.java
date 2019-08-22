package sxk.demo.spring.demo8.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import sxk.demo.spring.demo8.bean.Bird;
import sxk.demo.spring.demo8.bean.Dove2;
import sxk.demo.spring.demo8.bean.Eagle;

/**
 * 加载beanDefinition的时候只看name如果name不存在就加载，如果已经存在就不加载了。
 * 1.两个同名的bean能否同时存在，能否通过名称取，取的是哪个
 * 如果类型相同：只会加载一个，已经存在的 beanDefinition 不会重复加载；
 * 如果类型不同：也只会加载一个，如果通过类型取那个没有加载到的，就会报错；
 * 配置类中的 Bean 会被优先加载
 * <p>
 * 2.两个相同类型的bean能否同时存在，能否通过类型取，取的是哪个，是否是同一个对象
 * 只要名称不同都能存在，只能通过名称取，不能通过类型对象
 * 3.注入的3种形式 Autowired(spring自带) Resource(JSR-250) Inject(JSR-330)
 * Resource 也支持 Primary。
 * Inject 需要导第3方的包
 * 4.Primary 是针对需要注入的是父类型，但是我有多个子类型，那么会默认使用打了Primary注解的
 * 5.Qualifier 当有多个相同类型的 bean 时通过 Qualifier 和 Autowired 或 Inject 固定取某个对象
 *
 * @author : sunxikai
 * @date : 2019-08-22
 */
@Configuration
@ComponentScan(value = "sxk.demo.spring.demo8.bean")
public class DemoConfiguration8 {

    /*
     虽然 Bird 中也打了 Component 注解，但是容器中确实只有 configBird
     显然只加载了配置类中的 bird
     */
    @Bean
    public Bird bird() {
        return new Bird("configBird");
    }

    @Bean
    public Dove2 dove() {
        return new Dove2("configDove");
    }

    @Bean("eagle1")
    public Eagle eagle() {
        return new Eagle();
    }

}
